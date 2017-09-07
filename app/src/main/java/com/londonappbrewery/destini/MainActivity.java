package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView viewStory;
    Button btnAnswerTop;
    Button btnAnswerBottom;

    int intIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        viewStory = (TextView) findViewById(R.id.storyTextView);
        btnAnswerTop = (Button) findViewById(R.id.buttonTop);
        btnAnswerBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        if (savedInstanceState == null) {
            intIndex = R.string.T1_Story;
            displayStory();
        } else {
            intIndex = (int) savedInstanceState.get("storyIndex");
            displayStory();
        }

        btnAnswerTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(btnAnswerTop);
                displayStory();
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btnAnswerBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(btnAnswerBottom);
                displayStory();
            }
        });

    }

    public void updateStory(Button btn) {
        if ((intIndex == R.string.T1_Story && btn == btnAnswerTop) || (intIndex == R.string.T2_Story && btn == btnAnswerTop)) {
            intIndex = R.string.T3_Story;
        } else if (intIndex == R.string.T3_Story && btn == btnAnswerTop) {
            intIndex = R.string.T6_End;
        } else if (intIndex == R.string.T1_Story && btn == btnAnswerBottom) {
            intIndex = R.string.T2_Story;
        } else if (intIndex == R.string.T2_Story && btn == btnAnswerBottom) {
            intIndex = R.string.T4_End;
        } else if (intIndex == R.string.T3_Story && btn == btnAnswerBottom) {
            intIndex = R.string.T5_End;
        } else {
            intIndex = R.string.T1_Story;
        }
    }

    public void displayStory() {
        viewStory.setText(intIndex);
        if (intIndex == R.string.T1_Story) {
            btnAnswerTop.setText(R.string.T1_Ans1);
            btnAnswerBottom.setText(R.string.T1_Ans2);
            btnAnswerBottom.setVisibility(View.VISIBLE);
        } else if (intIndex == R.string.T2_Story) {
            btnAnswerTop.setText(R.string.T2_Ans1);
            btnAnswerBottom.setText(R.string.T2_Ans2);
        } else if (intIndex == R.string.T3_Story) {
            btnAnswerTop.setText(R.string.T3_Ans1);
            btnAnswerBottom.setText(R.string.T3_Ans2);
        } else if (intIndex == R.string.T4_End || intIndex == R.string.T5_End || intIndex == R.string.T6_End) {
            //btnAnswerTop.setVisibility(View.GONE);
            btnAnswerTop.setText("Restart");
            btnAnswerBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("storyIndex", intIndex);
    }
}
