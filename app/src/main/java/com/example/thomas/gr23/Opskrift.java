package com.example.thomas.gr23;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Opskrift extends AppCompatActivity implements View.OnClickListener {
    Button tilfoejknap, sletknap;
    private LinearLayout parentlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opskrift);

        Spinner spinner = findViewById(R.id.gentagelserspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gentagelser, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        tilfoejknap = findViewById(R.id.tilfoejtrin);
        tilfoejknap.setOnClickListener(this);

        sletknap = findViewById(R.id.sletknap);
        sletknap.setOnClickListener(this);

        parentlayout = findViewById(R.id.parentlayout);
    }

    @Override
    public void onClick(View v) {
        if (v == tilfoejknap){
            tilfoejtrin(v);
        } else if (v == sletknap){
            slettrin(v);
        }
    }

    public void tilfoejtrin(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.trin, null);
        // Add the new row before the add field button.
        parentlayout.addView(rowView, parentlayout.getChildCount() - 2);
    }

    public void slettrin(View v) {
        parentlayout.removeViewAt(parentlayout.getChildCount() - 3);
    }
}
