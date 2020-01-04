package kz.aa.store.orders.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderItemDto implements Serializable {
    private static final long serialversionUID = 129348938L;

    private Long id;
    private int count;
}
