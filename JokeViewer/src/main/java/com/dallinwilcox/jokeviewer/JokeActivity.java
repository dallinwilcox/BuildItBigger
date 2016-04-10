package com.dallinwilcox.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_STRING = "jokeString";
    String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        View view = findViewById(R.id.content);
        getIntent().getStringExtra(JOKE_STRING);
        Snackbar.make(view, joke, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


    }
}
