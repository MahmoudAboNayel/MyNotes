package com.example.abo_nayel.mynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText nm,ps;
    Button login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        login = (Button) findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm = (EditText) findViewById(R.id.nameedt);
                ps = (EditText) findViewById(R.id.passedt);


//                    Bundle b = getIntent().getExtras();
//                    String name = b.getString("name" );
//                    String password = b.getString("password" );
                    if (nm.getText().toString().equals("m") && ps.getText().toString().equals("123") ){
                        Intent i = new Intent(Login.this , Notes.class);
                        i.putExtra("name" , "m");
                        startActivity(i);
                    }



                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Sign Up ..." , Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
    public void btnSignUpClick(View v){
        Intent i = new Intent(Login.this ,SignUp.class );
        startActivity(i);
    }
//    public void btnLoginClick(View v){
//        Bundle b = getIntent().getExtras();
//        String name = b.getString("name");
//        String password = b.getString("password");
//
//        nm = (EditText) findViewById(R.id.nameedt);
//        ps = (EditText) findViewById(R.id.passedt);
//
//        if (name == nm.getText().toString() && password == ps.getText().toString() ){
//            Intent i = new Intent(Login.this , Notes.class);
//            i.putExtra("name" , name);
//            startActivity(i);
//        }
//    }
}
