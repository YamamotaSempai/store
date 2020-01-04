package kz.aa.store.orders.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aa.store.orders.model.dto.OrderItemDto;
import kz.aa.store.orders.repository.BasketRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
public class BasketService {
    private final BasketRedisRepository basketRedisRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public BasketService(BasketRedisRepository basketRedisRepository, ObjectMapper objectMapper) {
        this.basketRedisRepository = basketRedisRepository;
        this.objectMapper = objectMapper;
    }

    public boolean addIntoBasket(@Valid OrderItemDto baseItem) {
        try {
            String content = objectMapper.writeValueAsString(baseItem);
            basketRedisRepository.addIntoBasket(content);
            return true;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void resetBasket(String username) {
        basketRedisRepository.resetBasket(username);
    }

    public OrderItemDto[] getAllByUsername() {
        List<String> basketValues = basketRedisRepository.getAllByUsername();
        if (basketValues != null && basketValues.size() > 0) {
            try {
                StringBuilder source = new StringBuilder()
                        .append("[")
                        .append(String.join(",", basketValues))
                        .append("]");
                return objectMapper.readValue(source.toString(), OrderItemDto[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new ResponseStatusException(
                        HttpStatus.NO_CONTENT, "basket is empty"
                );
            }
        }

        return null;
    }
}
