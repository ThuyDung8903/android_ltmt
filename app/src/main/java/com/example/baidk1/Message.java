package com.example.baidk1;

public class Message {
    private String code;
    private String date;
    private String time;

    public Message(String text, String date, String time) {
        this.code = text;
        this.date = date;
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
