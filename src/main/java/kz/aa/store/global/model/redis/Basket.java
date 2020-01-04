package kz.aa.store.global.model.redis;

import kz.aa.store.global.model.base.BaseItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RedisHash("basket")
public class Basket {
    @Id
    private Long id;
    private List<BaseItem> items;
    private String username;
    private LocalDateTime createdDate;
}
