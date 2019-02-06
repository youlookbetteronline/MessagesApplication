package com.example.gav.messagesapplication.model;

import com.example.gav.messagesapplication.Constants;

public class AdvertisingMessage implements BaseModel {

    private String message;
    private String date;
    private String iconURL;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    @Override
    public int getViewType() {
        return Constants.ADVERTISING;
    }
}
