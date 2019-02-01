package com.fashioncatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_reg;
    EditText ed_uname, ed_pass, ed_email;
    int user_cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_reg = (Button) findViewById(R.id.btn_reg);

        ed_uname = (EditText) findViewById(R.id.ed_uname);
        ed_pass = (EditText) findViewById(R.id.ed_pass);
        ed_email = (EditText) findViewById(R.id.ed_email);

        final DatabaseHandler db = new DatabaseHandler(this);

        user_cnt = db.getAllUserCount();

        //Toast.makeText(getApplicationContext(), "" + user_cnt, Toast.LENGTH_LONG).show();

        if(user_cnt != 0)
        {
            Intent int_login = new Intent(getApplicationContext(), SelectionActivity.class);
            startActivity(int_login);
        }
        else {
            Toast.makeText(getApplicationContext(), "No user found", Toast.LENGTH_LONG).show();
        }

        Log.d("Insert:", "Inserting...");
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Contact(ed_uname.getText().toString(), ed_pass.getText().toString(), ed_email.getText().toString()));

                Intent int_login = new Intent(getApplicationContext(), LoginActivity.class);
                int_login.putExtra("_NAME", ed_uname.getText().toString());
                startActivity(int_login);
            }
        });

//        Log.d("Reading: ", "Reading information");
//        List<Contact> contacts = db.getAllContacts();
//
//        for (Contact cn : contacts) {
//            String log = "Id: " + cn.getID() + " Name: " + cn.getName() + " Password: " + cn.getPass() + "Email:" + cn.getEmail();
//
//            Toast.makeText(getApplicationContext(), log, Toast.LENGTH_LONG).show();
//        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}