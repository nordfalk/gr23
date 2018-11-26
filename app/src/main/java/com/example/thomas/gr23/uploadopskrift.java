package com.example.thomas.gr23;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class uploadopskrift extends AppCompatActivity implements View.OnClickListener {
    Button tilfoejopskrift;
    ImageButton tilfoejbilleder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadopskrift);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.svaehedsgrad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        tilfoejopskrift = findViewById(R.id.opkriftknap);
        tilfoejopskrift.setOnClickListener(this);

        tilfoejbilleder = findViewById(R.id.oploadbilled);
        tilfoejbilleder.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == tilfoejopskrift){
            Intent i = new Intent(this, Opskrift.class);


        } else if (v == tilfoejbilleder){
            // kode taget fra stackoverflow: https://stackoverflow.com/questions/19585815/select-multiple-images-from-android-gallery
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Picture"), 2);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1){

        }

        if (requestCode == 2){

        }
    }

}
