package com.example.bahung.imageviewzoom.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ImageTask {

    @SerializedName("state")
    @Expose
    private boolean state;
    @SerializedName("data")
    @Expose
    private ArrayList<DataImageTask> data = null;

    public boolean isState() {
        return state;
    }


    public ArrayList<DataImageTask> getData() {
        return data;
    }


}