package com.example.tg_patient_profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WeeklyActivityProfilingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_profiling);



        LinearLayout weeklyActivityProfilingLayout = findViewById(R.id.weeklyActivityProfilingLayout);

        int choicesNum = getResources().getStringArray(R.array.WeeklyActivitySummaryText).length;

        TypedArray titles = getResources().obtainTypedArray(R.array.WeeklyActivitySummaryTitleText);
        String[] texts = getResources().getStringArray(R.array.WeeklyActivitySummaryText);
        TypedArray imgs = getResources().obtainTypedArray(R.array.WeeklyActivitySummaryImage);

        for (int i = 0; i < choicesNum; i++) {
            String text = texts[i];
            String title = titles.getString(i);
            int img = imgs.getResourceId(i, -1);

            View statusView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.patient_weekly_activity_summary_layout, null);
            ImageView weeklyActivityImageView = statusView.findViewById(R.id.weeklyActivitySummaryIV);
            TextView weeklyActivitySummaryTitleTextView = statusView.findViewById(R.id.weeklyActivitySummaryTitleTV);
            TextView weeklyActivitySummaryTextView = statusView.findViewById(R.id.weeklyActivitySummaryTV);

            weeklyActivityImageView.setImageResource(img);
            weeklyActivitySummaryTitleTextView.setText(title);
            weeklyActivitySummaryTextView.setText(Html.fromHtml(text));
//            weeklyActivitySummaryTextView.setClickable(true);
//            weeklyActivitySummaryTextView.setMovementMethod(LinkMovementMethod.getInstance());

            weeklyActivityProfilingLayout.addView(statusView);
        }
    }
}