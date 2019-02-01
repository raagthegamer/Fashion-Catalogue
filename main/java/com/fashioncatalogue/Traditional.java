package com.fashioncatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Traditional extends AppCompatActivity {


    ImageView tv_kameez, tv_salwar, tv_saree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional);

        tv_kameez = (ImageView) findViewById(R.id.tv_kameez);
        tv_salwar = (ImageView) findViewById(R.id.tv_salwar);
        tv_saree = (ImageView) findViewById(R.id.tv_saree);

        tv_kameez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_kam = new Intent(getApplicationContext(),KameezActivity.class);
                startActivity(int_kam);
            }
        });

        tv_salwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_sal = new Intent(getApplicationContext(),SalwarActivity.class);
                startActivity(int_sal);
            }
        });

        tv_saree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_saree = new Intent(getApplicationContext(),SaareActivity.class);
                startActivity(int_saree);
            }
        });
    }
}
