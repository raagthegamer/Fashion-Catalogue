package com.fashioncatalogue;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText ed_uname;
    EditText ed_pass;

    String uname;

    String url = "http://joshiraag.000webhostapp.com";
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pd = new ProgressDialog(LoginActivity.this);

        btn_login = (Button) findViewById(R.id.btn_login);

        ed_uname = (EditText) findViewById(R.id.ed_uname);
        ed_pass = (EditText) findViewById(R.id.ed_pass);

//        Intent int_login = getIntent();
//        uname = int_login.getStringExtra("_NAME");

        final DatabaseHandler db = new DatabaseHandler(this);

        //ed_uname.setText(uname.toString());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (db.getContactsCount(ed_uname.getText().toString(), ed_pass.getText().toString()) != 0) {
//                    Intent int_selection = new Intent(getApplicationContext(), SelectionActivity.class);
//                    startActivity(int_selection);
//                } else {
//                    Toast.makeText(getApplicationContext(), "No user found", Toast.LENGTH_LONG).show();
//                }

                login(ed_uname.getText().toString(), ed_pass.getText().toString());
            }
        });
    }

    private void login(final String username, String password) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REAPI services = retrofit.create(REAPI.class);

        Call<String> call = services.login(username, password);
        System.out.println(username + "" + password);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println("done " + response.body().toString());

                if (response.body().equals("logged_in")) {
                    Intent i = new Intent(getApplicationContext(), SelectionActivity.class);
                    i.putExtra("Username", username);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_LONG).show();
                }
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("error" + t.toString());
                pd.dismiss();
            }
        });
    }


    public void onBackPressed() {
        super.onBackPressed();
    }

}
