package com.example.shraddha.travellersguide;

public class RateData {
    private String username;
    private float rate;
    private String message;

    public RateData(String username, float rate, String message) {
        this.username = username;
        this.rate = rate;
         this.message= message;
    }

    public RateData() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
