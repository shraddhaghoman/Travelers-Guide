package com.example.shraddha.travellersguide.Tab_Cities.tabGoa;

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

public class tab1GoaDesc extends Fragment{
    private ImageView akshrdhama,qutub,rashtra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1goadesc, container, false);
        akshrdhama=(ImageView)rootView.findViewById(R.id.calan);
        qutub=(ImageView)rootView.findViewById(R.id.aguda);

        rashtra=(ImageView)rootView.findViewById(R.id.pan);
        akshrdhama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),calngut.class);
                startActivity(intent);
            }
        });
        qutub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),agudaf.class);
                startActivity(intent);
            }
        });
        rashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),panji.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
