package com.fashioncatalogue;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AndroidListAdapter extends ArrayAdapter {
    ArrayList<ProdModel> prodmodel;
    Context context;

    public AndroidListAdapter(Activity context, ArrayList<ProdModel> prodmodel) {
        super(context, R.layout.custom_list_item_layout, prodmodel);

        this.prodmodel = prodmodel;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.custom_list_item_layout, null, true);

        TextView mtextView = (TextView) viewRow.findViewById(R.id.text_view);
        TextView mtextView1 = (TextView) viewRow.findViewById(R.id.text_view1);
        ImageView mimageView = (ImageView) viewRow.findViewById(R.id.image_view);



        return viewRow;
    }
}