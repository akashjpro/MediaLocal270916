package com.akashjpro.medialocal270916;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnMp3, btnPause, btnPlayMP4;
    VideoView videoViewMP4;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.phanxachame);
        btnMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        btnPlayMP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoViewMP4.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.huvantruonglao));
                videoViewMP4.start();
                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(videoViewMP4);
                videoViewMP4.setMediaController(mediaController);
            }
        });
    }

    private void addControls() {
        btnMp3     = (Button) findViewById(R.id.buttonPlay);
        btnPause   = (Button) findViewById(R.id.buttonPause);
        btnPlayMP4 = (Button) findViewById(R.id.buttonPlayMp4);
        videoViewMP4 = (VideoView) findViewById(R.id.videoViewMp4);
    }
}
