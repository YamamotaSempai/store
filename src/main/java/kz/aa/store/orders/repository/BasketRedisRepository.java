package kz.aa.store.orders.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BasketRedisRepository {
    private final RedisTemplate<String, String> redisTemplate;
    private static final int START = 0;
    private static final int END = -1;

    @Autowired
    public BasketRedisRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addIntoBasket(String content) {
        redisTemplate.opsForList().leftPush("test", content); // TODO: 04.01.20 change key
    }

    public void resetBasket(String username) {
        redisTemplate.delete(username);
    }

    public List<String> getAllByUsername() {
        return redisTemplate.opsForList().range("test", START, END); // TODO: 04.01.20 change key
    }
}
