package com.example.thomas.gr23;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Store extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ImageView iv;
    ListView lv;
    String [] rec = new String[] {"sok", "hue"};
    ArrayAdapter adapter;
    LayoutInflater layoutInflater;
    Fragment f;
    Button b1, b2;



    //ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);


    // ArrayAdapter laver fejl

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_store);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, R.id.lvopskrift, rec);

      /*  adapter = new ArrayAdapter(this, R.layout.activity_store, R.id.lv, rec) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                TextView beskrivelse = view.findViewById(R.id.);
                ImageView billede = view.findViewById(R.id.);
                return view;
            }
        };*/



        lv = findViewById(R.id.lv);
        lv.setOnItemClickListener(this);
        lv.setAdapter(adapter);
        setContentView(R.layout.activity_store);

        iv.setImageResource(R.drawable.yarn);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // if(i == ){} // i er positionen og fortæller opskriften i opskritft aktiviteten

        if (view == b1) { // En knap på listen
       //     intent i = new Intent(this, Opskrift.class);
       //     i.putExtra(view.);

        }

        if (view == b2){
//https://stackoverflow.com/questions/17599450/how-to-inflate-view-inside-fragment#17599543

            LinearLayout linearLayout;
         //   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
         //       View rootView = inflater.inflate(R.layout.fragment_store, container, false);
            };

        }
    }

