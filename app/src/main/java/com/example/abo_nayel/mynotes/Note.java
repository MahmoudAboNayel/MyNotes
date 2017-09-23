package com.example.abo_nayel.mynotes;

import android.widget.CheckBox;

/**
 * Created by Abo-Nayel on 22/09/2017.
 */

public class Note {
    int id;
    String note;
    String status;
    String owner;

    public Note(int id, String note, String owner) {
        this.id = id;
        this.note = note;
        this.owner = owner;
    }

    public Note() {
    }

    public Note(String note, String owner) {
        this.note = note;
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
