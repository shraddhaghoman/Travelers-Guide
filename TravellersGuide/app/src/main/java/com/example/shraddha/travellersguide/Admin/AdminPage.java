package com.example.shraddha.travellersguide.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shraddha.travellersguide.R;

import org.w3c.dom.Text;

public class AdminPage extends AppCompatActivity {
TextView u,c,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        u=(TextView)findViewById(R.id.userinfor);
        r=(TextView)findViewById(R.id.userrating);
        c=(TextView)findViewById(R.id.cityvote);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Users.class);
                startActivity(intent);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UserRating.class);
                startActivity(intent);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CityVotes.class);
                startActivity(intent);
            }
        });
    }
}
