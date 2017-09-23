package com.example.abo_nayel.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abo-Nayel on 22/09/2017.
 */

public class NotesAdapter extends ArrayAdapter<Note> {
    public NotesAdapter(Context context, ArrayList<Note> notes) {

        super(context, 0, notes);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        final Note note = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_note_item, parent, false);
        }
        TextView notehome = (TextView) convertView.findViewById(R.id.note);
        final TextView statusHome = (TextView) convertView.findViewById(R.id.status);
        CheckBox c = (CheckBox) convertView.findViewById(R.id.checkBox);
        // Populate the data into the template view using the data object
        notehome.setText(note.getNote());
        statusHome.setText(note.getStatus());
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)statusHome.setText("Done");
                else statusHome.setText("Pending");
            }
        });
        notehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
