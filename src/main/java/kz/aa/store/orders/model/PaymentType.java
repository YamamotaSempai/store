package kz.aa.store.orders.model;

import java.io.Serializable;

public enum PaymentType implements Serializable {
    CASH(0), CARD(1);

    private int type;

    PaymentType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
