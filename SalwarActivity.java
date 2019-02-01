package com.fashioncatalogue;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class SalwarActivity extends AppCompatActivity {
    EditText ed_from,ed_to;
    Button btn_filter;

    String url = "http://joshiraag.000webhostapp.com";
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salwar);
        pd = new ProgressDialog(SalwarActivity.this);

        ed_from = (EditText) findViewById(R.id.ed_from);
        ed_to = (EditText) findViewById(R.id.ed_to);
        btn_filter = (Button) findViewById(R.id.btn_filter);

        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetSalwar(ed_from.getText().toString(),ed_to.getText().toString());
            }
        });
    }

    private void GetSalwar(final String from, String to) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REAPI services = retrofit.create(REAPI.class);

        Call<List<ProductModel>> call = services.ProductDetail("Salwar", from, to);

        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                //Log.e(">>>>>>>>>>>>>>", response.body().get(0).getPrice());

                ArrayList<ProdModel> prodlist = new ArrayList<ProdModel>();

                for (int i = 0; i < response.body().size(); i++) {
                    ProdModel prodModel = new ProdModel();
                    prodModel.setDetail(response.body().get(i).getDetail());
                    prodModel.setDistributor(response.body().get(i).getDistributor());
                    prodModel.setPrice(response.body().get(i).getPrice());
                    prodModel.setProdName(response.body().get(i).getProdName());
                    prodModel.setProdType(response.body().get(i).getProdType());
                    prodModel.setQty(response.body().get(i).getQty());

                    prodlist.add(prodModel);
                }

                AndroidListAdapter androidListAdapter = new AndroidListAdapter(SalwarActivity.this, prodlist);

                ListView androidListView = (ListView) findViewById(R.id.list_salwar);
                androidListView.setAdapter(androidListAdapter);
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {

            }
        });
    }



    }

