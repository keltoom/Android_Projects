package com.keltoom.destini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView storyView ;
    Button answerOneButton;
    Button answerTwoButton;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyView = findViewById(R.id.storyTextView);
        answerOneButton = findViewById(R.id.buttonTop);
        answerTwoButton = findViewById(R.id.buttonBottom);

        answerOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex==1 || mStoryIndex==2){
                    mStoryIndex=3;
                    storyView.setText(R.string.T3_Story);
                    answerOneButton.setText(R.string.T3_Ans1);
                    answerTwoButton.setText(R.string.T3_Ans2);
                }
                else{
                    storyView.setText(R.string.T6_End);
                    answerOneButton.setVisibility(View.GONE);
                    answerTwoButton.setVisibility(View.GONE);
                }

            }
        });

        answerTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex==1){
                    mStoryIndex=2;
                    storyView.setText(R.string.T2_Story);
                    answerOneButton.setText(R.string.T2_Ans1);
                    answerTwoButton.setText(R.string.T2_Ans2);
                }else if (mStoryIndex==2){
                    storyView.setText(R.string.T4_End);
                    answerOneButton.setVisibility(View.GONE);
                    answerTwoButton.setVisibility(View.GONE);
                }else {
                    storyView.setText(R.string.T5_End);
                    answerOneButton.setVisibility(View.GONE);
                    answerTwoButton.setVisibility(View.GONE);
                }

            }
        });
    }
}