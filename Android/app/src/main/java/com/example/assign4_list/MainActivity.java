package com.example.assign4_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        String[] words = new String[100];
        for(int i=0; i<100; i++){
            words[i] = "words" + i;
        }
        RecycleViewAdapter a = new RecycleViewAdapter(words);
        recyclerView.setAdapter(a);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}