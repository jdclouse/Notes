package com.johnclouse.notes;

import android.app.ListActivity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.johnclouse.notes.data.NoteItem;
import com.johnclouse.notes.data.NotesDataSource;

import java.util.List;


public class MainActivity extends ListActivity {

    private NotesDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new NotesDataSource(this); //"this" needed if there is a non-default constr.

        refreshDisplay();

        List<NoteItem> notes = dataSource.findall();
        NoteItem note = notes.get(0);
        note.setText("Updated!");

        dataSource.update(note);

        notes = dataSource.findall();
        note = notes.get(0);

        Log.i("NOTES", note.getKey() + ": " + note.getText()); // Logs for debugging.
    }

    private void refreshDisplay() {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
