package com.example.demo.controller;


import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LMSController {
    protected ResponseEntity<?> buildResponse(Object data, HttpStatus httpStatus){
        return new ResponseEntity<?>(data , httpStatus);
    }

    protected ResponseEntity<?> buildResponse(HttpStatus httpStatus){
        ResponseEntity<String> responseEntity = new ResponseEntity<?>(httpStatus);
        return responseEntity;
    }
}
