package com.example.thomas.gr23;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{
    Button butik, forum;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tv = findViewById(R.id.tvy);
        tv.setText("Velkommen til YARNET");

        butik = (Button) findViewById(R.id.butik);
        butik.setOnClickListener(this);
        forum = (Button) findViewById(R.id.forum);
        forum.setOnClickListener(this);

        boolean EMULATOR = Build.PRODUCT.contains("sdk") || Build.MODEL.contains("Emulator");
        if (!EMULATOR) {
            Fabric.with(this, new Crashlytics());
        }

    }


    @Override
    public void onClick(View view) {
        if (view == butik) {
            Intent i = new Intent(this,Store.class);
            startActivity(i);
        }
        if (view == forum) {
            Intent i = new Intent(this, Forum.class);
            startActivity(i);
        }
    }
}
