package org.example.productservice.exception;

public enum ErrorCode {
//    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
//    INVALID_KEY(1001, "Uncategorized error"),
    PRODUCT_EXISTED(1002, "User existed"),
    PRODUCT_NOT_FOUND(1003, "Product not found"),
//    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
//    INVALID_PASSWORD(1004, "Password must be at least 8 characters")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}