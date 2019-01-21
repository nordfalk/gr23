package com.example.thomas.gr23;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    static int pos;
    static String[] lande = {"Danmark", "Norge", "Sverige", "Finland", "Holland", "Italien", "Tyskland",
            "Frankrig", "Spanien", "Portugal", "Nepal", "Indien", "Kina", "Japan", "Thailand"};

    ListView gratis, betaling;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home /*R.layout.activity_gridview*/, container, false);




        ArrayAdapter gratisAdapter = new ArrayAdapter(getActivity(), R.layout.listeelement, R.id.overskrift, lande){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                TextView beskrivelse = v.findViewById(R.id.beskrivelse);
                //settext
                ImageView iv = v.findViewById(R.id.billede);
                iv.setImageResource(R.drawable.abe);

                return v;
            }
        };

        gratis = view.findViewById(R.id.gratis);
        gratis.setOnItemClickListener(this);
        gratis.setAdapter(gratisAdapter);

        ArrayAdapter betalingAdapter = new ArrayAdapter(getActivity(), R.layout.listeelement, R.id.overskrift, lande){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                TextView beskrivelse = v.findViewById(R.id.beskrivelse);
                //settext
                ImageView iv = v.findViewById(R.id.billede);
                iv.setImageResource(R.drawable.person_icon);

                return v;
            }
        };

        betaling = view.findViewById(R.id.betaling);
        betaling.setOnItemClickListener(this);
        betaling.setAdapter(betalingAdapter);

       return view;//inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        pos = position;

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");

        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        DialogFragment dialogFragment = new MyCustomDialogFragment();
        dialogFragment.show(ft, "dialog");


        //dialogFragment.dismiss();


        if (view == gratis) {
            if (position == 7) {



            } //
            else {


            }//

        }

    }

    // MyCustomDialogFragment lånt fra https://medium.com/@xabaras/creating-a-custom-dialog-with-dialogfragment-f0198dab656d
    public static class MyCustomDialogFragment extends DialogFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_detaljeret_opskrift, container, false);

            TextView overskrift = v.findViewById(R.id.overskrift);
            overskrift.setText("Hej position "+pos + "land: "+lande[pos]);
            ImageButton luk = v.findViewById(R.id.luk);
            luk.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

            //dismiss();
            // Do all the stuff to initialize your custom view

            return v;
        }
    }


}
