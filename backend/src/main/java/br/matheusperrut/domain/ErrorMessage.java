package br.matheusperrut.domain;

import java.util.List;

public class ErrorMessage {
    private List<ErrorMessageDescription> message;

    public List<ErrorMessageDescription> getMessage() {
        return message;
    }

    public void setMessage(List<ErrorMessageDescription> message) {
        this.message = message;
    }
}
