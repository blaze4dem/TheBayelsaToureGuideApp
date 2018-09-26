package com.example.android.thebayelsatoureguideapp;


import android.content.Context;
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
public class CoolSpotsfragment extends Fragment {

    private Context mContext;

    public CoolSpotsfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Places> places = new ArrayList<>();

        places.add(new Places(getString(R.string.ox), getString(R.string.ox_head), R.drawable.ox,
                getString(R.string.ox_desc),false));
        places.add(new Places(getString(R.string.os), getString(R.string.os_head), R.drawable.spa,
                getString(R.string.os_desc),false));
        places.add(new Places(getString(R.string.bw), getString(R.string.bw_head), R.drawable.car,
                getString(R.string.bw_desc),false));
        places.add(new Places(getString(R.string.ms), getString(R.string.ms_head), R.drawable.mall,
                getString(R.string.ms_desc),
                false));
        places.add(new Places(getString(R.string.bbr), getString(R.string.bbr_head), R.drawable.morning,
                getString(R.string.bbr_desc),false));


        ListView listView = (ListView) inflater.inflate(R.layout.activity_listview, container, false);

        ListView listId = (ListView) listView.findViewById(R.id.list);

        PlacesArrayAdapter adapter = new PlacesArrayAdapter(getActivity(), places, R.color.cool);

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
