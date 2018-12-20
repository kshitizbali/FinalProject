package com.jokeme.thejokersplayground;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DisplayJokes extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        TextView instructions_text_view = (TextView) findViewById(R.id.instructions_text_view);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(ConstantUtils.INTENT_JOKE);
        instructions_text_view.setText(joke);
        progressBar.setVisibility(View.GONE);
        instructions_text_view.setVisibility(View.VISIBLE);
    }


    /*public void tellJoke(View view) {

    }*/
}
