package com.example.tehtava2;

public class Data {

    static Data data = new Data();
    private String text, previousText;
    private boolean editable = true;

    private Data() {}

    public static Data getInstance() {
        return data;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public String getPreviousText() {
        return previousText;
    }

    public void setPreviousText(String previousText) {
        this.previousText = previousText;
    }
}
