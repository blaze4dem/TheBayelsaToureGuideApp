package com.example.android.thebayelsatoureguideapp;

public class Places {

    private String placeName;
    private String placeHeading = null;
    private int NO_IMAGE = -1;
    private int placeImageId = NO_IMAGE;

    private String placeDescription;
    private boolean placeShowDescription = false;
    private int NO_PHONE = -1;
    private int placePhoneNumber = NO_PHONE;

    public Places (String name, String heading, int imageId, String description, boolean showDescription){

        placeName = name;
        placeHeading = heading;
        placeImageId = imageId;
        placeDescription = description;
        placeShowDescription = showDescription;
    }

    public Places (String name, String description, int phone, boolean showDescription){

        placeName = name;
        placeDescription = description;
        placePhoneNumber = phone;
        placeShowDescription = showDescription;
    }

    public String getPlaceName(){ return placeName;}
    public String getPlaceHeading(){ return placeHeading;}
    public String getPlaceDescription(){ return placeDescription;}
    public int getPlaceImageId(){ return placeImageId;}
    public int getPlacePhoneNumber(){ return placePhoneNumber;}

    // Check if place has heading
    public boolean hasHeading(){
        return placeHeading != null;
    }
    // Check if place has Phone Number
    public boolean hasPhoneNumber(){return placePhoneNumber != NO_PHONE;}

    // Check if place has image
    public boolean hasImage(){return placeImageId != NO_IMAGE;}

    // Show or Hide Description
    public boolean descriptionDisplay(){
        return placeShowDescription;
    }
}
