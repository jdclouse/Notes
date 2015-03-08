package com.johnclouse.notes.data;

/**
 * Created by John on 3/7/2015.
 */
public class NoteItem {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String key;
    private String text;
}
