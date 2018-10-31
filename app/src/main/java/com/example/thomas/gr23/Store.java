package com.example.thomas.gr23;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Store extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    String [] rec = {"sok", "hue"};


    // ArrayAdapter laver fejl
    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_store);

            adapter = new ArrayAdapter(this, R.layout.activity_store, R.id.lv, rec) {
                @Override
                public View getView(int position, View cachedView, ViewGroup parent) {
                    View view = super.getView(position, cachedView, parent);
                    return view;
                }
            };



        lv = findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
        lv.setAdapter(adapter);
        setContentView(R.layout.activity_store);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
       // if(i == ){} // i er positionen og fortæller opskriften i opskritft aktiviteten

    }

}
