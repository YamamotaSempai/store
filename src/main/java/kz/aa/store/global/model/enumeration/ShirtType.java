package kz.aa.store.global.model.enumeration;

public enum ShirtType {
    DEFAULT(0), POLO(1);

    private Integer code;

    ShirtType(Integer code) {
        this.code = code;
    }

    private Integer getCode() {
        return this.code;
    }
}
