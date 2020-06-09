package com.example.shraddha.travellersguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Report extends AppCompatActivity {


    private EditText a_subject,a_message;
    private String email,s_subject,s_message;
    private Button feed;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        a_subject=(EditText)findViewById(R.id.subject);
        a_message=(EditText)findViewById(R.id.msg);
        feed=(Button)findViewById(R.id.submit);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myfeed();
            }

        });
        user=FirebaseAuth.getInstance().getCurrentUser();
        email=user.getDisplayName();

    }
    public void myfeed()
    {
        initialize1();
        if(!validate1())
        {
            Toast toast= Toast.makeText(this,"Submit Failed",Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            onSuccess();
        }
    }
    public Boolean validate1()
    {
        boolean valid=true;

        if(s_subject.isEmpty())
        {
            a_subject.setError("Please Enter Contact No");
            valid=false;
        }
        if(s_message.isEmpty())
        {
            a_message.setError("Please Enter Contact No");
            valid=false;
        }
        return valid;
    }
    public void onSuccess()
    {

        Intent i=new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"travelll.guide@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT,s_subject);
        i.putExtra(Intent.EXTRA_TEXT,"Dear Administrator, \n"
                + s_message );
        try
        {
            startActivity(Intent.createChooser(i,"send mail"));
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(this,"No Email app Found",Toast.LENGTH_SHORT).show();

        }catch(Exception ex)
        {
            Toast.makeText(this,"Unexpected Error" +ex.toString(),Toast.LENGTH_SHORT).show();
        }
    }
    public void initialize1()
    {

        s_subject=a_subject.getText().toString().trim();
        s_message=a_message.getText().toString().trim();

    }
}
