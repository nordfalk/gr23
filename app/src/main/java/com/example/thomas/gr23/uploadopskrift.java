package com.example.thomas.gr23;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

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

        Spinner spinnerkategori = findViewById(R.id.kategorispinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.kategorier, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerkategori.setAdapter(adapter1);


        tilfoejopskrift = findViewById(R.id.opkriftknap);
        tilfoejopskrift.setOnClickListener(this);

        tilfoejbilleder = findViewById(R.id.oploadbilled);
        tilfoejbilleder.setOnClickListener(this);

        boolean EMULATOR = Build.PRODUCT.contains("sdk") || Build.MODEL.contains("Emulator");
        if (!EMULATOR) {
            Fabric.with(this, new Crashlytics());
        }

    }


    @Override
    public void onClick(View v) {
        if(v == tilfoejopskrift){
            Intent i = new Intent(this, Opskrift.class);
            startActivityForResult(i,1);


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
            if (resultCode == Activity.RESULT_OK){
                Toast.makeText(this, "Du har tilføjet en opskrift", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == 2){

        }
    }

}
