package com.example.musicapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlayListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        ImageView toHomeBack = findViewById(R.id.toHomeBack);
        toHomeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               PlayListActivity.this.finish();
            }
        });
//        ArrayAdapter<String> adapter  = new ArrayAdapter<>(PlayListActivity.this,R.layout.play_list,data);
//        ListView listView = (ListView) findViewById(R.id.playlist);
//        listView.setAdapter(adapter);
    }
}
