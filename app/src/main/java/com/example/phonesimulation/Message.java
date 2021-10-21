package com.example.phonesimulation;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private String textMessage;
    private String ReceiversName;
    private int id;

    //constructor

    public Message(String textMessage, String receiversName, int id) {
        this.textMessage = textMessage;
        ReceiversName = receiversName;
        this.id = id;
    }
    //getter and setter

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getReceiversName() {
        return ReceiversName;
    }

    public void setReceiversName(String receiversName) {
        ReceiversName = receiversName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
