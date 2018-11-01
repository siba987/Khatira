package com.hcid.advprog.hatira.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.hcid.advprog.hatira.R;

public class AlbumGrid extends AppCompatActivity {


    ImageView imageView;
    private static final int REQUEST_OPEN_RESULT_CODE = 0;
    private static final int MY_PERMISSION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //equivalent to setting view

        setTitle("Album Grid");
    }
}
