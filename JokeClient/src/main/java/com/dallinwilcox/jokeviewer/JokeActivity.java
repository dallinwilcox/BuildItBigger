package com.dallinwilcox.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_STRING = "jokeString";
    String joke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeView = (TextView)findViewById(R.id.jokeText);
        jokeView.setText(getIntent().getStringExtra(JOKE_STRING));
    }
}
