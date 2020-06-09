package com.example.shraddha.travellersguide.Account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shraddha.travellersguide.CityActivity;
import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.RateData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Rate extends AppCompatActivity {

    RatingBar ratingBar;
    EditText tellUs;
    TextView greet;
    Button submit;
    String user,tell;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase mauth;
    private DatabaseReference mdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        mauth=FirebaseDatabase.getInstance();
        mdata=mauth.getReference();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        submit=(Button)findViewById(R.id.submitRate);
        ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        tellUs=(EditText)findViewById(R.id.tellUs);
        greet=(TextView)findViewById(R.id.greet);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=firebaseUser.getUid();
                final Float ratingNumber=ratingBar.getRating();
                tell=tellUs.getText().toString();
                RateData r=new RateData(user,ratingNumber,tell);
                mdata.child("Rating").push().setValue(r);
               Intent intent=new Intent(getApplicationContext(),CityActivity.class);
               startActivity(intent);
               finish();
            }
        });
    }
}
