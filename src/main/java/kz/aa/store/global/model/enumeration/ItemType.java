package kz.aa.store.global.model.enumeration;

public enum ItemType {
    PANTS(0), SHIRT(1);

    private int code;

    ItemType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
