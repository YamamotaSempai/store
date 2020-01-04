package kz.aa.store.orders.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.aa.store.orders.annotation.FullOrderCheck;
import kz.aa.store.orders.model.PaymentType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@FullOrderCheck
public class OrderDto implements Serializable {
    private List<OrderItemDto> orderItemDtoList;
    private String address;
    private PaymentType paymentType;

    @JsonIgnore
    private Long orderId;
}
