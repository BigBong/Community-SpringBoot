package org.community.api;

/**
 * Created by frodoking on 2016/12/29.
 */
public class ResponseJsonWrapper<T> {
    private int status;
    private String message;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
