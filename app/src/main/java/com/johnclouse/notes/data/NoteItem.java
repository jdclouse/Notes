package com.johnclouse.notes.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    public static NoteItem getNew() {
        Locale locale = new Locale("en_US"); // For easily sorted timestamp
        Locale.setDefault(locale);

        String pattern = "yyyy-MM-dd HH:mm:ss Z"; // Z adds offset from GMT
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String key = formatter.format(new Date());

        NoteItem note = new NoteItem();
        note.setKey(key);
        note.setText("");
        return note;

    }

    private String key;
    private String text;
}
