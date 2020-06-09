package com.example.shraddha.travellersguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shraddha.travellersguide.Account.Rate;
import com.example.shraddha.travellersguide.Tab_Cities.Agra.Agra_tab;
import com.example.shraddha.travellersguide.Tab_Cities.tabDehli.Dehli_tab;
import com.example.shraddha.travellersguide.Tab_Cities.tabGoa.Goa_tab;
import com.example.shraddha.travellersguide.Tab_Cities.tabJaipur.Jaipur_tab;
import com.example.shraddha.travellersguide.Tab_Cities.tabManali.Manali_tab;
import com.example.shraddha.travellersguide.Tab_Cities.tabMumbai.Mumbai_tab;
import com.google.firebase.auth.FirebaseAuth;

public class CityActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
           ImageButton goa,agra,manali,jaipur,mumbai,dehli;
           TextView user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       dehli=(ImageButton)findViewById(R.id.dehli);
       jaipur=(ImageButton)findViewById(R.id.jaipur);
        agra=(ImageButton)findViewById(R.id.agra);
        goa=(ImageButton)findViewById(R.id.goa);
        mumbai=(ImageButton)findViewById(R.id.mumbai);
        manali=(ImageButton)findViewById(R.id.manali);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        user1=(TextView)findViewById(R.id.user);
       // user1.setText(getIntent().getExtras("username"));
       dehli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Dehli_tab.class);
                startActivity(intent);
            }
        });
        goa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Goa_tab.class);
                startActivity(intent);
            }
        });
        jaipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Jaipur_tab.class);
                startActivity(intent);
            }
        });
        manali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Manali_tab.class);
                startActivity(intent);
            }
        });

        agra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Agra_tab.class);
                startActivity(intent);
            }
        });
        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Mumbai_tab.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.states, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_help) {
            Intent intent=new Intent(this,Help.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_profile)
        {
            Intent intent=new Intent(this,Profile.class);
            startActivity(intent);
        }
       else if (id == R.id.nav_logout)
        {
            FirebaseAuth.getInstance().signOut();
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        else if(id == R.id.nav_rate)
        {
            Intent intent=new Intent(this,Rate.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_city) {

            Intent intent=new Intent(this,VoteCity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_report) {

               Intent intent=new Intent(this,Report.class);
               startActivity(intent);
        }
        else if (id == R.id.nav_share) {

            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,"http://www.mediafire.com/file/t8qhub3hk2moop0/app-debug.apk/file");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"Choose App to Share"));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
