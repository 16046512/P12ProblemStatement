package com.example.a16046512.problemstatement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {
    private ImageView ivp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ivp = (ImageView)findViewById(R.id.rpiv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Picasso.get()
                .load("https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg")
                .placeholder(R.drawable.ajax_loader)
                .error(R.drawable.error)
                .into(ivp);
        // Inflate the layout for this fragment
    }
}
