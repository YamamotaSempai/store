package kz.aa.store.global.model.enumeration;

public enum Sex {
    UNISEX(0), MALE(1), FEMALE(2);

    private int code;

    Sex(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
