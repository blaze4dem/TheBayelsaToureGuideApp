package com.example.android.thebayelsatoureguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlacesArrayAdapter extends ArrayAdapter<Places> {

    private int mColorResourceId;

    public PlacesArrayAdapter(Context context, ArrayList<Places> places, int colorResourceId ) {
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check view if it exit and inflate if not

        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_single_item, parent, false);
        }

        // Get the current place object
        Places currentPlace = getItem(position);

        // Add text view content to view

        TextView placeName = (TextView) listItem.findViewById(R.id.placeName);
        placeName.setText(currentPlace.getPlaceName());

        // Check if place has heading or not and set view accordingly

        TextView placeHeading = (TextView) listItem.findViewById(R.id.placeHeading);
        if (currentPlace.hasHeading()){
            placeHeading.setText(currentPlace.getPlaceHeading());
            placeHeading.setVisibility(View.VISIBLE);
        }else{
            placeHeading.setVisibility(View.GONE);
        }

        // Set text on place Description

        TextView placeDescription = (TextView) listItem.findViewById(R.id.placeDescription);

        if (currentPlace.descriptionDisplay()){
            placeDescription.setText(currentPlace.getPlaceDescription());
            placeDescription.setVisibility(View.VISIBLE);
        }else{
            placeDescription.setVisibility(View.GONE);
        }


        // Check if vew has image and add or hide content

        ImageView placeImage = (ImageView) listItem.findViewById(R.id.placeImage);
        if (currentPlace.hasImage()){
            placeImage.setImageResource(currentPlace.getPlaceImageId());
            placeImage.setVisibility(View.VISIBLE);
        }else{
            placeImage.setVisibility(View.GONE);
        }

        // Check if vew has phone Number and add or hide content

        TextView placePhone = (TextView) listItem.findViewById(R.id.placePhoneNumber);
        if (currentPlace.hasPhoneNumber()){
            placePhone.setText(String.valueOf(currentPlace.getPlacePhoneNumber()));
            placePhone.setVisibility(View.VISIBLE);
        }else{
            placePhone.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItem.findViewById(R.id.list_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        return listItem;
    }
}
