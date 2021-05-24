package com.example.screencompatibility2;

import android.os.Bundle;
import android.view.WindowInsets;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BackgroundActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        getSupportActionBar().hide();
        getWindow().getInsetsController().hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());

        progressBar = findViewById(R.id.pb_background_process);
        textView = findViewById(R.id.tv_background_process);

        progressBar.setMax(100);
        applyProgressBarAnimation();
    }

    public void applyProgressBarAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, textView, 0f, 100f);
        anim.setDuration(3000);
        progressBar.setAnimation(anim);
    }
}