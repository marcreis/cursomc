package com.marcreis.cursomc.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable throwable) {
        super(msg,throwable);
    }


}
