package com.hp.sculatask.model;

public class NotificationItemRecycleHeader {
   private String number;
   private int imageId;

    public NotificationItemRecycleHeader(String number, int imageId) {
        this.number = number;
        this.imageId = imageId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
