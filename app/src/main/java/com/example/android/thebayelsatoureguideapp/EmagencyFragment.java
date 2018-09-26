package com.example.android.thebayelsatoureguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmagencyFragment extends Fragment {


    public EmagencyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Places> places = new ArrayList<>();

        places.add(new Places(getString(R.string.police), getString(R.string.police_desc), R.string.police_num, true));
        places.add(new Places(getString(R.string.hospital), getString(R.string.hospital_desc), R.string.hospital_num, true));
        places.add(new Places(getString(R.string.fire), getString(R.string.fire_desc), R.string.fire_num, true));


        ListView listView = (ListView) inflater.inflate(R.layout.activity_listview, container, false);

        ListView listId = (ListView) listView.findViewById(R.id.list);

        PlacesArrayAdapter adapter = new PlacesArrayAdapter(getActivity(), places, R.color.emerg);

        listId.setAdapter(adapter);


        return listView;
    }

}
