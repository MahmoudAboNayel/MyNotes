package com.example.abo_nayel.mynotes;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Notes extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    Button add;
    EditText e;
    ArrayList<Note> arrayOfNotes = new ArrayList<>();
    NotesAdapter adapter;
    CheckBox x;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        add = (Button) findViewById(R.id.add);
        e = (EditText) findViewById(R.id.nota);
        x = (CheckBox) findViewById(R.id.checkBox);
        t = (TextView) findViewById(R.id.status);

        // Create the adapter to convert the array to views
        adapter = new NotesAdapter(getApplicationContext(),arrayOfNotes);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.myNotes);
        listView.setAdapter(adapter);
        List<Note> notes = db.getAllNotes();
        for ( Note n : notes) {
//            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//            // Writing Contacts to log
            arrayOfNotes.add(n);
            adapter.notifyDataSetChanged();

        }


    }

    public void addItems(View v) {

        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        arrayOfNotes.add(new Note(e.getText().toString(), "Pending"));

        adapter.notifyDataSetChanged();
        db.addNote(new Note(e.getText().toString(),name));
        e.setText("");
    }
    public void btnLogOutClick(View v){
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }
    public void deleteNote(View v){
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        int m = -1;
        for (int i =0 ; i <arrayOfNotes.size() ; i++) {
            if (arrayOfNotes.get(i).getNote().equals(e.getText())){
                 m = i;
            }
        }
        if (m != -1){
            db.deleteNote(arrayOfNotes.get(m));
            arrayOfNotes.remove(m);
            adapter.notifyDataSetChanged();
        }
        else  {Toast toast = Toast.makeText(getApplicationContext(), "this notes is not existed..." , Toast.LENGTH_LONG);
        toast.show();}
    }
}
