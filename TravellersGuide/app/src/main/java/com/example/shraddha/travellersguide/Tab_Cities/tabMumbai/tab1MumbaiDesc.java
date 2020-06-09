package com.example.shraddha.travellersguide.Tab_Cities.tabMumbai;

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

public class tab1MumbaiDesc extends Fragment{
    private ImageView akshrdhama,qutub,rashtra;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1mumbaidesc, container, false);
        akshrdhama=(ImageView)rootView.findViewById(R.id.ban);
        qutub=(ImageView)rootView.findViewById(R.id.ind);

        rashtra=(ImageView)rootView.findViewById(R.id.nar);
        akshrdhama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),bandra.class);
                startActivity(intent);
            }
        });
        qutub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),india.class);
                startActivity(intent);
            }
        });
        rashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),narim.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
