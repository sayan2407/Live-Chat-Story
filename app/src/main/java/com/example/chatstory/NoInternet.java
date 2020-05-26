package com.example.chatstory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoInternet extends Fragment {

    Button button;

    public NoInternet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_no_internet, container, false);
        button=v.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavageMom noInternet=new SavageMom();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.savage1,noInternet);
                transaction.commit();

            }
        });

        return v;
    }
}
