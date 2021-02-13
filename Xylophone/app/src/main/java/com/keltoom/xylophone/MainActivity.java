package com.keltoom.xylophone;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.AudioAttributes;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    final private int MAX_STREAM=7;
    final private float LEFT_VOLUME=0.1f;
    final private float RIGHT_VOLUME=0.1f;
    final private int PRIORITY=0;
    final private int NO_LOOP=0;
    final private float NORMAL_PLAY_RATE=1.0f;
    private SoundPool mSoundPool;
    private AudioAttributes audioAttributes;

    private int mCsoundId;
    private int mDsoundId;
    private int mEsoundId;
    private int mFsoundId;
    private int mGsoundId;
    private int mAsoundId;
    private int mBsoundId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            audioAttributes= new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build();

            mSoundPool = new SoundPool.Builder()
                    .setMaxStreams(MAX_STREAM)
                    .setAudioAttributes(audioAttributes).build();
        }
        else{
            mSoundPool=new SoundPool(MAX_STREAM,AudioManager.STREAM_MUSIC,0);
        }

        mCsoundId =mSoundPool.load(getApplicationContext(),R.raw.note1_c,1);
        mDsoundId =mSoundPool.load(getApplicationContext(),R.raw.note2_d,1);
        mEsoundId =mSoundPool.load(getApplicationContext(),R.raw.note3_e,1);
        mFsoundId =mSoundPool.load(getApplicationContext(),R.raw.note4_f,1);
        mGsoundId =mSoundPool.load(getApplicationContext(),R.raw.note5_g,1);
        mAsoundId =mSoundPool.load(getApplicationContext(),R.raw.note6_a,1);
        mBsoundId =mSoundPool.load(getApplicationContext(),R.raw.note7_b,1);
    }
    public void playC(View v){
        Log.d("key C","clicked!!");
        mSoundPool.play(mCsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
    public void playD(View v){
        mSoundPool.play(mDsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
    public void playE(View v){
        mSoundPool.play(mEsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
    public void playF(View v){
        mSoundPool.play(mFsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
    public void playG(View v){
        mSoundPool.play(mGsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
    public void playA(View v){
        mSoundPool.play(mAsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
    public void playB(View v){
        mSoundPool.play(mBsoundId,LEFT_VOLUME,RIGHT_VOLUME,PRIORITY,NO_LOOP,NORMAL_PLAY_RATE);
    }
}