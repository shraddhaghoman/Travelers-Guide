package com.example.shraddha.travellersguide.Tab_Cities.tabDehli;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.Tab_Cities.Agra.MapsActivity;

public class tab1DehliDesc extends Fragment{
   private ImageView akshrdhama,qutub,rashtra;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1dehlidesc, container, false);
        akshrdhama=(ImageView)rootView.findViewById(R.id.ak);
        qutub=(ImageView)rootView.findViewById(R.id.qu);

        rashtra=(ImageView)rootView.findViewById(R.id.ras);
        akshrdhama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),delhi1.class);
                startActivity(intent);
            }
        });
        qutub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),qutubminar.class);
                startActivity(intent);
            }
        });
        rashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),rashtrapati.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
