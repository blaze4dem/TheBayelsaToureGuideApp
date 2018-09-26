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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Places> places = new ArrayList<>();

        places.add(new Places(getString(R.string.ah), getString(R.string.af_head), R.drawable.aridolf,
                getString(R.string.af_desc), false));
        places.add(new Places(getString(R.string.as), getString(R.string.as_head), R.drawable.suite,
                getString(R.string.as_desc), false));
        places.add(new Places(getString(R.string.bs_), getString(R.string.bs_head) , R.drawable.beach,
                getString(R.string.bs_desc), false));
        places.add(new Places(getString(R.string.ayh), getString(R.string.ayh_head), R.drawable.suiteclass,
                getString(R.string.ayh_desk), false));
        places.add(new Places(getString(R.string.sm), getString(R.string.sm_head), R.drawable.build,
                getString(R.string.sm_desk), false));


        ListView listView = (ListView) inflater.inflate(R.layout.activity_listview, container, false);

        ListView listId = (ListView) listView.findViewById(R.id.list);

        PlacesArrayAdapter adapter = new PlacesArrayAdapter(getActivity(), places, R.color.hotels);

        listId.setAdapter(adapter);

        listId.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Places place = (Places) adapterView.getItemAtPosition(i);
                Intent showDetails = new Intent(getContext(), Details.class);
                showDetails.putExtra("placeName", place.getPlaceName());
                showDetails.putExtra("placeDescription", place.getPlaceDescription());
                showDetails.putExtra("placeImage", place.getPlaceImageId());
                startActivity(showDetails);
            }
        });

        return listView;
    }

}
