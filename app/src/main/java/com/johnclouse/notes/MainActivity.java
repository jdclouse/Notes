package com.johnclouse.notes;

import android.app.Fragment;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.johnclouse.notes.data.NoteItem;
import com.johnclouse.notes.data.NotesDataSource;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private NotesDataSource dataSource;
    List<NoteItem> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new NotesDataSource(this); //"this" needed if there is a non-default constr.+
        ListFrag fragment = new ListFrag();
        getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();

        refreshDisplay(fragment);

    }

    private void refreshDisplay(ListFrag theList) {
        notesList = dataSource.findall();
        ArrayAdapter<NoteItem> adapter =
                new ArrayAdapter<NoteItem>(this, R.layout.list_item_layout, notesList);
        theList.setListAdapter(adapter);
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
        if (id == R.id.action_create) {
            createNote();
        }

        return super.onOptionsItemSelected(item);
    }

    private void createNote() {
        NoteItem note = NoteItem.getNew();
        Intent intent = new Intent(this, NoteEditorActivity.class); //screen
        intent.putExtra("key", note.getKey());
        intent.putExtra("text", note.getText()); // data

        startActivityForResult(intent, 1001);
    }

    public static class ListFrag extends ListFragment {
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            //setListAdapter();  //Taking care of this in the main activity refresh.
        }
    }
}
