package com.example.spring_demo;

public class Response {
    private String massage;
    private Boolean status;

    public Response(String massage, Boolean status) {
        this.massage = massage;
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
