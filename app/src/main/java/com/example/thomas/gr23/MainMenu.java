package com.example.thomas.gr23;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{
    Button butik, forum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        butik = findViewById(R.id.butik);
        butik.setText("Butik");
        butik.setOnClickListener(this);
        forum = findViewById(R.id.forum);
        forum.setText("Forum");
        forum.setOnClickListener(this);




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
