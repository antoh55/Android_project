package com.example.patienttracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.patienttracker.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextUsername;
    private AppBarConfiguration appBarConfiguration;
    private ImageView h_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView h_logo = (ImageView) findViewById(R.id.h_imageView);
        h_logo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView h_emergency = findViewById(R.id.h_emergency);
        h_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:911"));
                        startActivity(intent);
            }
        });




        ImageView h_diagnose = (ImageView) findViewById(R.id.h_diagnose);
        h_diagnose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://symptomate.com/diagnosis/#0-66");
            }
        });

        ImageView h_records = (ImageView) findViewById(R.id.h_records);
        h_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Records.class);
                startActivity(intent);
            }
        });


        ImageView h_news = (ImageView) findViewById(R.id.h_news);
        h_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl();
            }
        });

        ImageView h_contact = (ImageView) findViewById(R.id.h_contact);
        h_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0701010101"));
                startActivity(intent);
            }
        });

        ImageView h_hospital = (ImageView) findViewById(R.id.h_hospital);
        h_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.google.com/search?q=nearby+hospital+near+me&rlz=1C1GCEA_enUS830US883&oq=nearby+hospital&aqs=chrome.3.0i512j69i57j0i512j0i20i263i457i512j0i512l6.10007j0j4&sourceid=chrome&ie=UTF-8"));
                startActivity(intent);
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse("https://symptomate.com/diagnosis/#0-66");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void gotoUrl() {
        Uri uri = Uri.parse("https://www.medicalnewstoday.com/");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}