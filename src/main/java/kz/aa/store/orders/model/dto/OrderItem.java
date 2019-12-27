package kz.aa.store.orders.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItem implements Serializable {
    private Long id;
    private int count;
}
