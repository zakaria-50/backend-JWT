package com.project.backend.exception;


import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExeption extends RuntimeException{
    private static final long serialVersionUID = 1L ;

    public NotFoundExeption(String message){
        super(message);
    }



}
