package com.example.shraddha.travellersguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VoteCity extends AppCompatActivity {
       EditText city;
       Button submit;
       TextView greet;
    private FirebaseDatabase mauth;
    private DatabaseReference mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_city);
        city=(EditText)findViewById(R.id.cityName);
        submit=(Button)findViewById(R.id.submitCity);
        greet=(TextView)findViewById(R.id.greettext);
        mauth=FirebaseDatabase.getInstance();
        mdata=mauth.getReference();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName=city.getText().toString();
                mdata.child("CityVote").push().setValue(cityName);
                greet.setText("Thank You");
                finish();
            }
        });

    }
}
