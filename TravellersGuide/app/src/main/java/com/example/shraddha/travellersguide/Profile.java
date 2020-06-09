package com.example.shraddha.travellersguide;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Profile extends AppCompatActivity {

    TextView f_name1,l_name1,contact1,email1;
    String fname,lname,email,contact,uid,s;
    FirebaseUser user;
FirebaseDatabase database;
DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        f_name1=(TextView) findViewById(R.id.f_name);
        l_name1=(TextView) findViewById(R.id.l_name);
        contact1=(TextView) findViewById(R.id.contact_no);
        email1=(TextView) findViewById(R.id.emailpro);
        user=FirebaseAuth.getInstance().getCurrentUser();
        s=user.getEmail();

         database=FirebaseDatabase.getInstance();
         myRef=database.getReference("Users");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    if(s.equals(data.child("email").getValue(String.class))) {
                        fname = data.child("fname").getValue(String.class);
                        lname = data.child("lname").getValue(String.class);
                        contact = data.child("contact_no").getValue(String.class);
                        email = data.child("email").getValue(String.class);
                    }

                }
                  f_name1.setText(fname);
                l_name1.setText(lname);
                email1.setText(email);
                contact1.setText(contact);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
        }


    }


