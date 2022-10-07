package br.com.sap.paymentservice.handler.exception;

import java.util.Date;

public class ErrorMessageResponse {
    private int httpStatus;
    private Date date;
    private String message;

    public ErrorMessageResponse(int httpStatus, Date date, String message) {
        this.httpStatus = httpStatus;
        this.date = date;
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public ErrorMessageResponse setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ErrorMessageResponse setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorMessageResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
