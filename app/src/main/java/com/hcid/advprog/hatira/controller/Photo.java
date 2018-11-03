package com.hcid.advprog.hatira.controller;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;

import com.hcid.advprog.hatira.R;
import com.hcid.advprog.hatira.model.PhotoModel;
import com.hcid.advprog.hatira.model.UserModel;

public class Photo extends AppCompatActivity  {
    private PhotoModel photoModel;

    //constructor, or does it get added to the onCreate method?
    public Photo(){
        photoModel = new PhotoModel();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);

        setTitle("Photo View");

        //set Enter and Exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(null);
            getWindow().setExitTransition(null);
        }

    }
}
