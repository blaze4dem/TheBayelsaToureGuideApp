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
public class ResturantsFragment extends Fragment {


    public ResturantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Places> places = new ArrayList<>();

        places.add(new Places(getString(R.string.cr), getString(R.string.cr_head), R.drawable.chicken,
                getString(R.string.cr_desc), false));
        places.add(new Places(getString(R.string.df), getString(R.string.df_head), R.drawable.classymeal,
                getString(R.string.df_desc), false));
        places.add(new Places(getString(R.string.cck), getString(R.string.cck_head), R.drawable.foods,
                getString(R.string.cck_desc), false));
        places.add(new Places(getString(R.string.cd), getString(R.string.cd_head), R.drawable.coffee,
                getString(R.string.cd_desc), false));
        places.add(new Places(getString(R.string.ss), getString(R.string.ss_head), R.drawable.shawama,
                getString(R.string.ss_desc), false));


        ListView listView = (ListView) inflater.inflate(R.layout.activity_listview, container, false);

        ListView listId = (ListView) listView.findViewById(R.id.list);

        PlacesArrayAdapter adapter = new PlacesArrayAdapter(getActivity(), places, R.color.rest);

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
