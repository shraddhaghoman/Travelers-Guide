package com.example.shraddha.travellersguide.Tab_Cities.tabDehli;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.Tab_Cities.Agra.MapsActivity;

public class tab3DehliMap extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3dehlimap, container, false);
        ImageView hotel=(ImageView)rootView.findViewById(R.id.mapdelhi);
        ImageView food=(ImageView)rootView.findViewById(R.id.weadelhi);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MapsActivitydelhi.class);
                startActivity(intent);

            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),delhiweather.class);
                startActivity(intent);

            }
        });
        return rootView;
    }
}
