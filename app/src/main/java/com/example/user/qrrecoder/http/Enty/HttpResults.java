package com.example.user.qrrecoder.http.Enty;

/**
 * Created by dxs on 2017/11/17.
 */

public class HttpResults<T> {
    private String resultCode;
    private String resultMessage;

    private T data;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
