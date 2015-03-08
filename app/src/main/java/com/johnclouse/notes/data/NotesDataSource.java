package com.johnclouse.notes.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 3/7/2015.
 */
public class NotesDataSource {

    public List<NoteItem> findall() {

        List<NoteItem> noteList = new ArrayList<NoteItem>(); //ArrayList is a concrete class that uses List interface.
        // Stores data in order you put it in (duh)
        NoteItem note = NoteItem.getNew();
        noteList.add(note);
        return noteList;

    }

    public boolean update(NoteItem note) {
        return true;
    }

    public boolean remove(NoteItem ntoe) {
        return true;
    }
}
