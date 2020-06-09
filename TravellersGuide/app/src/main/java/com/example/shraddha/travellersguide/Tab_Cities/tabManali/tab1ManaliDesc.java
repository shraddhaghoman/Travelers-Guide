package com.example.shraddha.travellersguide.Tab_Cities.tabManali;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.Tab_Cities.tabJaipur.amberfor;
import com.example.shraddha.travellersguide.Tab_Cities.tabJaipur.jalmaha;
import com.example.shraddha.travellersguide.Tab_Cities.tabJaipur.jantarman;

public class tab1ManaliDesc extends Fragment{
    private ImageView akshrdhama,qutub,rashtra;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1manalidesc, container, false);
        akshrdhama=(ImageView)rootView.findViewById(R.id.hid);
        qutub=(ImageView)rootView.findViewById(R.id.rah);

        rashtra=(ImageView)rootView.findViewById(R.id.roh);
        akshrdhama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),hidimba.class);
                startActivity(intent);
            }
        });
        qutub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),rihan.class);
                startActivity(intent);
            }
        });
        rashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),rohtan.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
