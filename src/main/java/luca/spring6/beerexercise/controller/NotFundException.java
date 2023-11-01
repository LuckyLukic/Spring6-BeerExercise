package luca.spring6.beerexercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Value Not Found")
public class NotFundException extends RuntimeException{
    public NotFundException() {
    }

    public NotFundException(String message) {
        super(message);
    }

    public NotFundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFundException(Throwable cause) {
        super(cause);
    }

    public NotFundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
