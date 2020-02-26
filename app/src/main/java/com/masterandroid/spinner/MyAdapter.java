package com.masterandroid.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    int[] flags;
    String[] countryNames;
    Context context;
    private LayoutInflater inflater;

    MyAdapter(Context context, int[] flags, String[] countryNames){
        this.context=context;
        this.flags=flags;
        this.countryNames=countryNames;
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sapmple_view,parent,false);


        }

        TextView textView = convertView.findViewById(R.id.simpleTextViewId);
        ImageView imageView = convertView.findViewById(R.id.spinnerImagesId);

        textView.setText(countryNames[position]);
        imageView.setImageResource(flags[position]);
        return convertView;
    }
}
