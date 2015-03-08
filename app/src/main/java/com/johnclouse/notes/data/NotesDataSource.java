package com.johnclouse.notes.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 3/7/2015.
 */
public class NotesDataSource {

    private static final String PREFKEY = "notes"; // A constant. All-caps is Java-ism.
    private SharedPreferences notePrefs;

    public NotesDataSource(Context context) {
        notePrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
    }

    public List<NoteItem> findall() {

        List<NoteItem> noteList = new ArrayList<NoteItem>(); //ArrayList is a concrete class that uses List interface.
        // Stores data in order you put it in (duh)
        NoteItem note = NoteItem.getNew();
        noteList.add(note);
        return noteList;

    }

    public boolean update(NoteItem note) {

        SharedPreferences.Editor editor = notePrefs.edit();
        editor.putString(note.getKey(), note.getText());
        editor.commit();

        return true;
    }

    public boolean remove(NoteItem note) {

        if (notePrefs.contains(note.getKey())) {
            SharedPreferences.Editor editor = notePrefs.edit();
            editor.remove(note.getKey());
            editor.commit();
        }

        return true;
    }
}
