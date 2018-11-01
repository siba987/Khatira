package com.hcid.advprog.hatira.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.hcid.advprog.hatira.R;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    private static final int REQUEST_OPEN_RESULT_CODE = 0;
    private static final int MY_PERMISSION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //equivalent to setting view

        setTitle("Activity 1");
        /*//for smoother transitions
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        //this excludes transition and action bar from this transition
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);

        //set Enter and Exit transition
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);*/

        //set Enter and Exit transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(null);
            getWindow().setExitTransition(null);
        }

        Button next = findViewById(R.id.nxt_button);

       // loadButton.setOnClickListener(this);
        next.setOnClickListener(this);
        /*
        loadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(MainActivity.this, Photo.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imageView, ViewCompat.getTransitionName(imageView));
                startActivity(intent,options.toBundle());
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                //to open filechooser
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_OPEN_RESULT_CODE);
            }
        });


        scene2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Photo.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imageView, ViewCompat.getTransitionName(imageView));
                startActivity(intent,options.toBundle());
            }
        });*/
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
          /*  case R.id.load:
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                //to open filechooser
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_OPEN_RESULT_CODE);
                break;*/
            case R.id.nxt_button:
                Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this, AlbumGrid.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imageView, ViewCompat.getTransitionName(imageView));
                startActivity(in,options.toBundle());
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        //check if resultCode has come back to us
        if (requestCode == REQUEST_OPEN_RESULT_CODE && resultCode == RESULT_OK) {
            //obtain URI, i.e. location of data to process
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData(); //returns address
                //loads bitmap member into ImageView
                Bitmap bitmap = null;
                try {
                    bitmap = getBitmapFromUri(uri);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        //create parsable file descriptor
        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        //use bitmap factory message
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return bitmap;
    }

}
