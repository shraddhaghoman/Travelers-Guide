package com.example.shraddha.travellersguide.Admin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shraddha.travellersguide.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class AdminLogin extends AppCompatActivity {
EditText adname,adpass;
TextView login;
    FirebaseDatabase database;
    DatabaseReference myRef;
   // String u,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        adname=(EditText)findViewById(R.id.adminname);
        adpass=(EditText)findViewById(R.id.adminpassword);
        login=(TextView)findViewById(R.id.adlogin);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Query query=myRef.child("Admin").orderByChild("adminName").equalTo(adname.getText().toString().trim());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                        {
                            for(DataSnapshot user : dataSnapshot.getChildren())
                            {
                                if((adpass.getText().toString().trim()).equals(user.child("password").getValue(String.class)))
                                {
                                    Intent intent=new Intent(getApplicationContext(),AdminPage.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Password Wrong",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),AdminLogin.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Admin not found",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),AdminLogin.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

    }
}
