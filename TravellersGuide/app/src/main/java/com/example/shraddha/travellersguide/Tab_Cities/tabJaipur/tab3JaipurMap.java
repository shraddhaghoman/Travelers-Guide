package com.example.shraddha.travellersguide.Tab_Cities.tabJaipur;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.Tab_Cities.tabGoa.MapsActivitygoa;

public class tab3JaipurMap extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3jaipurmap, container, false);
        ImageView hotel=(ImageView)rootView.findViewById(R.id.mapjaipur);
        ImageView food=(ImageView)rootView.findViewById(R.id.weajaipur);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MapsActivityjaipur.class);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),jaipurweather.class);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
