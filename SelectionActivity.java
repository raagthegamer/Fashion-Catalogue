package com.fashioncatalogue;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SelectionActivity extends AppCompatActivity {

    ImageView i1;
    ImageView i2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        i1 = (ImageView) findViewById(R.id.tv_trad);
        i2 = (ImageView) findViewById(R.id.tv_casual);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_trad = new Intent(getApplicationContext(),Traditional.class);
                int_trad.putExtra("_TYPE", "traditional");
                startActivity(int_trad);

            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_cas = new Intent(getApplicationContext(),Casual.class);
                int_cas.putExtra("_TYPE", "casual");
                startActivity(int_cas);
            }
        });
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }
}
