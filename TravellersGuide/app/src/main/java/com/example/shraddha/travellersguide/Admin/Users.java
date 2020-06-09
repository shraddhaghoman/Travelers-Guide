package com.example.shraddha.travellersguide.Admin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.shraddha.travellersguide.userData;
import com.example.shraddha.travellersguide.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Users extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    private ListView listvote;
    String fname,lname,contact,email;
    private ArrayList<String> muserlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Users");
        listvote=(ListView)findViewById(R.id.userlist);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,muserlist);
        listvote.setAdapter(arrayAdapter);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    fname = data.child("fname").getValue(String.class);
                    lname = data.child("lname").getValue(String.class);
                    contact = data.child("contact_no").getValue(String.class);
                    email = data.child("email").getValue(String.class);
                    muserlist.add("First Name: "+fname+"\n\n"+"Last Name: "+lname+"\n\n"+"Contact: "+contact+"\n\n"+"E-mail Id: "+email);
                    }

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
