package com.hcid.advprog.hatira.controller;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.hcid.advprog.hatira.R;

public class AlbumGrid extends AppCompatActivity implements View.OnClickListener{

    ImageButton imageButton;
    private static final String TAG = "AlbumGrid";
    private static final int REQUEST_OPEN_RESULT_CODE = 0;
    private static final int MY_PERMISSION_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_grid_activity); //equivalent to setting view
        Log.d(TAG, "onCreate: started.");
        setTitle("Album Grid");

        /*ImageView image1 = (ImageView) findViewById(R.id.imageView1);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        ImageView image4 = (ImageView) findViewById(R.id.imageView4);
        ImageView image5 = (ImageView) findViewById(R.id.imageView5);

        //init int to pass into imageResource
        int imgRsrc1 = getResources().getIdentifier("@drawable/adorable_cat", null, this.getPackageName());

        //setting resource to imageView
        image1.setImageResource(imgRsrc1);*/

        imageButton = (ImageButton) findViewById(R.id.cat_imgBtn);
        imageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
          /*  case R.id.load:
                Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                //to open filechooser
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_OPEN_RESULT_CODE);
                break;*/
            case R.id.cat_imgBtn:
                Toast.makeText(this, "Cat album clicked", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AlbumGrid.this, Photo.class);
                startActivity(in);
                break;
        }
    }
}
