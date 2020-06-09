package com.example.shraddha.travellersguide.Tab_Cities.tabGoa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;

public class tab3GoaMap extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3goamap, container, false);
        ImageView hotel=(ImageView)rootView.findViewById(R.id.mapgoa);
        ImageView food=(ImageView)rootView.findViewById(R.id.weagoa);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MapsActivitygoa.class);
                startActivity(intent);

            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),goaweather.class);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
