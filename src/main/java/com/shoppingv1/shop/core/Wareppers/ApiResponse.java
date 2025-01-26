package com.shoppingv1.shop.core.Wareppers;

public class ApiResponse<T> {

    private T data;
    private String message;
    private boolean success;

    public ApiResponse() {
    }

    public ApiResponse(T data, String message, boolean success) {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public ApiResponse(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
