package com.example.shraddha.travellersguide.Tab_Cities.tabMumbai;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;

public class tab3MumbaiMap extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3mumbaimap, container, false);
        ImageView hotel=(ImageView)rootView.findViewById(R.id.mapmum);
        ImageView food=(ImageView)rootView.findViewById(R.id.weamum);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MapsActivitymumbai.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),mumbaiweather.class);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
