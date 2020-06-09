package com.example.shraddha.travellersguide.Tab_Cities.tabJaipur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.Tab_Cities.Agra.akbartomb;
import com.example.shraddha.travellersguide.Tab_Cities.Agra.redfort;
import com.example.shraddha.travellersguide.Tab_Cities.Agra.taj;

public class tab1JaipurDesc extends Fragment{
    private ImageView akshrdhama,qutub,rashtra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1jaipurdesc, container, false);
        akshrdhama=(ImageView)rootView.findViewById(R.id.amber);
        qutub=(ImageView)rootView.findViewById(R.id.jal);

        rashtra=(ImageView)rootView.findViewById(R.id.jantar);
        akshrdhama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),amberfor.class);
                startActivity(intent);
            }
        });
        qutub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),jalmaha.class);
                startActivity(intent);
            }
        });
        rashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),jantarman.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
