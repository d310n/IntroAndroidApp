package com.example.introandroidapp;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class SongActivity extends AppCompatActivity {

   private VideoView vidView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        vidView = (VideoView) findViewById(R.id.vidView);
                vidView.setMediaController(new MediaController(this)); //add media controller
                Uri video = Uri.parse("android.resource://" +getPackageName()+ "/"+ R.raw.goodmorning);
                vidView.setVideoURI(video);
                vidView.setZOrderOnTop(true); //don't merge video with other widgets
    }

    protected void onResume() {
        super.onResume();
        vidView.start();
    }

    protected void onPause() {
        vidView.stopPlayback();
        super.onPause();
    }

}
