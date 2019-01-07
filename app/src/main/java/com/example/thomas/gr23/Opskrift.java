package com.example.thomas.gr23;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Opskrift extends AppCompatActivity implements View.OnClickListener {
    Button tilfoejknap, sletknap;
    private LinearLayout parentlayout;
    Menu menu;
    String data;

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

        // rowView.findViewById(R.id.trinnummer) = 9999999999999999999999999;
        // Add the new row before the add field button.

        parentlayout.addView(rowView, parentlayout.getChildCount() - 2);
    }

    public void slettrin(View v) {
        parentlayout.removeViewAt(parentlayout.getChildCount() - 3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opskrift_actionbar_buttons, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.faerdig:
                Intent returIntent = new Intent();
                returIntent.putExtra("resultat",data);
                setResult(Activity.RESULT_OK,returIntent);
                finish();
                break;

            case R.id.afbryd:
                Intent afbrudtIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,afbrudtIntent);
                finish();
                break;
        }

        return true;
    }

}
