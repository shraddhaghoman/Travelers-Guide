package com.example.shraddha.travellersguide.Tab_Cities.tabManali;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;

public class tab3ManaliMap extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3manalimap, container, false);
        ImageView hotel=(ImageView)rootView.findViewById(R.id.mapman);
        ImageView food=(ImageView)rootView.findViewById(R.id.weaman);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MapsActivitymanali.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),manaliweather.class);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
