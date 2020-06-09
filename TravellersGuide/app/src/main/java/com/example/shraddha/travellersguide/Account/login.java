package com.example.shraddha.travellersguide.Account;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shraddha.travellersguide.Admin.AdminLogin;
import com.example.shraddha.travellersguide.R;
import com.example.shraddha.travellersguide.CityActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
public class login extends AppCompatActivity {
       EditText username,password;
       TextView no_acc;
       TextView login,adminlogin;
       String user;
      private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mAuth = FirebaseAuth.getInstance();
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        login=(TextView) findViewById(R.id.login);
        no_acc=(TextView)findViewById(R.id.no_Acc);
        adminlogin=(TextView)findViewById(R.id.adminlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if((!(username.getText().toString().isEmpty())) && (!(password.getText().toString().isEmpty()))) {
                    (mAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast toast= Toast.makeText(getApplicationContext(),"login Successfull",Toast.LENGTH_SHORT);
                                toast.show();
                                Intent intent=new Intent(getApplicationContext(),CityActivity.class);
                                intent.putExtra("username",mAuth.getCurrentUser().getEmail().toString());
                                startActivity(intent);

                            }
                            else
                            {
                                Log.e("Error...",task.getException().toString());
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                            finish();
                        }
                    });

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please Enter valid Data",Toast.LENGTH_SHORT).show();
                }
            }
        });

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(intent);
            }
        });



        no_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();

            }
        });

    }


    public void openRegistration()
    {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
