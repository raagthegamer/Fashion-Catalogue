package com.fashioncatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Casual extends AppCompatActivity {
    ImageView tv_jeans,tv_tshirts,tv_skirts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casual);

        tv_jeans = (ImageView) findViewById(R.id.tv_jeans);
        tv_tshirts = (ImageView) findViewById(R.id.tv_tshirts);
        tv_skirts = (ImageView) findViewById(R.id.tv_skirts);


        tv_jeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_jeans = new Intent(getApplicationContext(),JeansActivity.class);
                startActivity(int_jeans);
            }
        });

        tv_tshirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_tshirts = new Intent(getApplicationContext(),TshirtActivity.class);
                startActivity(int_tshirts);
            }
        });

        tv_skirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_skirts = new Intent(getApplicationContext(),SkirtActivity.class);
                startActivity(int_skirts);
            }
        });
    }
}
