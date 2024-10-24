package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> cities;

    public MyAdapter(Context context, List<String> cities) {
        super(context, R.layout.list_item, cities);
        this.context = context;
        this.cities = cities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView cityName = rowView.findViewById(R.id.cityName);
        cityName.setText(cities.get(position));

        return rowView;
    }
}
