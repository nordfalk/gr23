package com.example.thomas.gr23;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OpskriftFragment extends Fragment implements View.OnClickListener {
    Button naeste;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_opskrift, container, false);

        naeste = view.findViewById(R.id.naeste);
        naeste.setOnClickListener(this);


        return view;
    }

    public void showOtherFragment(){
        Fragment fr=new UploadbillederFragment();
        FragmentChangeListener fc=(FragmentChangeListener)getActivity();
        fc.replaceFragment(fr);
    }

    @Override
    public void onClick(View v) {
        if(v == naeste){
            //todo sørg for at gemme dataen i fragmentet
            showOtherFragment();

        }
    }
}
