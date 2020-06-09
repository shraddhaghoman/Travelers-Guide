package com.example.shraddha.travellersguide.Tab_Cities.Agra;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.Tab_Cities.tabDehli.delhi1;
import com.example.shraddha.travellersguide.Tab_Cities.tabDehli.qutubminar;
import com.example.shraddha.travellersguide.Tab_Cities.tabDehli.rashtrapati;

public class tab1AgraDesc extends Fragment{
    private ImageView akshrdhama,qutub,rashtra;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1agradesc, container, false);
        akshrdhama=(ImageView)rootView.findViewById(R.id.akbar);
        qutub=(ImageView)rootView.findViewById(R.id.redfor);

        rashtra=(ImageView)rootView.findViewById(R.id.taj1);
        akshrdhama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),akbartomb.class);
                startActivity(intent);
            }
        });
        qutub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),redfort.class);
                startActivity(intent);
            }
        });
        rashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),taj.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
