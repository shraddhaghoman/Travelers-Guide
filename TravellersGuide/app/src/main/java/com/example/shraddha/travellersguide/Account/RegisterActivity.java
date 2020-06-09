package com.example.shraddha.travellersguide.Account;

import android.app.ProgressDialog;
import android.content.Intent;
import com.example.shraddha.travellersguide.userData;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.shraddha.travellersguide.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


   private EditText af_name,al_name,a_password,a_contact_no,a_email;
    private String f_name,l_name,password,contact_no,email;
    Button register;
   private FirebaseAuth mAuth;
   private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        mAuth = FirebaseAuth.getInstance();
        mdatabase=FirebaseDatabase.getInstance().getReference();
        af_name=(EditText)findViewById(R.id.firstName);
        al_name=(EditText)findViewById(R.id.lastName);
        a_email=(EditText)findViewById(R.id.email);
        a_contact_no=(EditText)findViewById(R.id.contactNo);
        a_password=(EditText)findViewById(R.id.Password);
        register=(Button)findViewById(R.id.Submit);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }
    public void register()
    {
        initialize();

        if(!validate())
        {
           Toast toast= Toast.makeText(this,"SignUp has Failed",Toast.LENGTH_SHORT);
           toast.show();
        }
        else
        {
           // final ProgressDialog progressDialog=ProgressDialog.show(getApplicationContext(),"Please wait...","Processing");
            (mAuth.createUserWithEmailAndPassword(a_email.getText().toString(),a_password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   // progressDialog.dismiss();
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT);
                        userData user= new userData(f_name,l_name,contact_no,email);
                        mdatabase.child("Users").push().setValue(user);
                        af_name.setText("");
                        al_name.setText("");
                        a_password.setText("");
                        a_contact_no.setText("");
                        a_email.setText("");
                        Intent intent=new Intent(getApplicationContext(),login.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Log.e("Error...",task.getException().toString());
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public Boolean validate()
    {
        boolean valid=true;
        if(f_name.isEmpty() || f_name.length()>12) {
            af_name.setError("Please Enter Valid Fisrt Name");
            valid=false;
        }
         if(l_name.isEmpty() || l_name.length()>12) {
             al_name.setError("Please Enter Valid Last Name");
             valid=false;
         }

         if(email.isEmpty() ||!Patterns.EMAIL_ADDRESS.matcher(email).matches())
         {
             a_email.setError("Enter Valid Email Address");
             valid=false;
         }
         if(contact_no.isEmpty())
         {
             a_contact_no.setError("Please Enter Contact No");
             valid=false;
         }
        if(password.isEmpty())
        {
            a_password.setError("Please Enter Contact No");
            valid=false;
        }
        return valid;
    }
    public void initialize()
    {
        f_name=af_name.getText().toString().trim();
        l_name=al_name.getText().toString().trim();
        email=a_email.getText().toString().trim();
        contact_no=a_contact_no.getText().toString().trim();
        password=a_password.getText().toString().trim();

    }
}
