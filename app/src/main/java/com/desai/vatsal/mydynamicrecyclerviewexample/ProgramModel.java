package com.desai.vatsal.mydynamicrecyclerviewexample;

/**
 * Created by HCL on 15-11-2016.
 */
public class ProgramModel {

    private String title;
    private String message;
    private int image;

    public ProgramModel(String title, String message, int image) {
        this.title = title;
        this.message = message;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
