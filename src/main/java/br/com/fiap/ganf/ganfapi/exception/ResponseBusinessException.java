package br.com.fiap.ganf.ganfapi.exception;

public class ResponseBusinessException extends Exception {

    private String message;

    public ResponseBusinessException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
