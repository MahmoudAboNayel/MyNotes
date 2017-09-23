package com.example.abo_nayel.mynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class YourData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_data);
        TextView txtinfo =(TextView) findViewById(R.id.txtData);

        Bundle b = getIntent().getExtras();
        String fname = b.getString("first name");
        String lname = b.getString("last name");
        String number = b.getString("my number");
        String mail = b.getString("mail");
        String Gender = b.getString("Gender");
        String msg = b.getString("msg");

        txtinfo.setText("Hey my name is " +
                fname + " " +
                lname +"\n"+
                "and my phone number is: " +number+ " " +
                "u can talk to me on whatsapp, " +"\n"+
                "Email: " + mail + "\n"+
                "for sure i am " + Gender +"\n" +
                "_____________"+ "\n" +
                "this is my message to you mr zamel : "+"\n"+msg);

    }
    public void btnMyNotesClick(View v){
        Intent i = new Intent(getApplicationContext(), Notes.class);
        startActivity(i);
    }
    public void btnLogOutClick(View v){
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }
}
