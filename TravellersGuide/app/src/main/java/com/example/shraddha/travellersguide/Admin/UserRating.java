package com.example.shraddha.travellersguide.Admin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shraddha.travellersguide.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserRating extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    private ListView listvote;
    String msg,user;
    Float rate;
    private ArrayList<String> mratelist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ratings);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Rating");
        listvote=(ListView)findViewById(R.id.ratelist);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mratelist);
        listvote.setAdapter(arrayAdapter);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    msg = data.child("message").getValue(String.class);
                    rate = data.child("rate").getValue(Float.class);
                    user = data.child("username").getValue(String.class);
                    mratelist.add("user: "+user+"\n\n"+"Rate: "+rate+"\n\n"+"Message: "+msg);
                }

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    }
