package com.hp.sculatask.model;

public class ItemRecycleHeader {
    private int imageId;
    private String title, notification;

    public ItemRecycleHeader(int imageId, String title, String notification) {
        this.imageId = imageId;
        this.title = title;
        this.notification = notification;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
