package com.johnclouse.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.johnclouse.notes.data.NoteItem;


public class NoteEditorActivity extends ActionBarActivity {

    private NoteItem note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
//        getActionBar().setDisplayHomeAsUpEnabled(true); //launcher icon will now go "home"

        Intent intent = this.getIntent();
        note = new NoteItem();
        note.setKey(intent.getStringExtra("key"));
        note.setText(intent.getStringExtra("text"));

        EditText et = (EditText) findViewById(R.id.noteText); //the text-editing interface
        et.setText(note.getText());
        if (note.getText() != null) { // In the event of an empty note... TODO don't save an empty one
            et.setSelection(note.getText().length()); //cursor at end
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_editor, menu);
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
            return true;
        }
        if (id == R.id.home) {
            saveAndFinish();
        }
        return false;


//        return super.onOptionsItemSelected(item);
    }

    // finishing is returning to the previous activity.
    private void saveAndFinish() {
        EditText et = (EditText) findViewById(R.id.noteText); //the text-editing interface
        String noteText = et.getText().toString(); // get the text from the editor

        Intent intent = new Intent();
        intent.putExtra("key", note.getKey());
        intent.putExtra("text", noteText);
        setResult(RESULT_OK, intent); // data saved persistently
        finish();

    }

    @Override
    public void onBackPressed() {
        saveAndFinish();
    }
}
