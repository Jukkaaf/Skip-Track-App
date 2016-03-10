package com.example.jukka.skiptrackapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if(am.isMusicActive()){
            skipTrackOnce();
        }
        finish();
        System.exit(0);
    }

    private void skipTrackOnce(){
        Intent intentD = new Intent(Intent.ACTION_MEDIA_BUTTON);
        Intent intentU = new Intent(Intent.ACTION_MEDIA_BUTTON);
        intentD.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_NEXT));
        intentU.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_NEXT));

        sendOrderedBroadcast(intentD, null);
        sendOrderedBroadcast(intentU, null);
    }
}
