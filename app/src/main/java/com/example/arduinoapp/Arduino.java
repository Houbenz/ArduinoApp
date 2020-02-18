package com.example.arduinoapp;

public class Arduino {

    private String message;
    private String mode;


    public Arduino(){

    }


    public String getMessage() {
        return message;
    }

    public String getMode() {
        return mode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
