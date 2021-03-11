package com.example.assign4_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        Button commitText = (Button) findViewById(R.id.button);
        String[] words = new String[100];
        for(int i=0; i<100; i++){
            words[i] = "words" + i;
        }
        final RecycleViewAdapter[] a = {new RecycleViewAdapter(words)};
        recyclerView.setAdapter(a[0]);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        commitText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                words[99] = "clicked";
                Arrays.sort(words);
                a[0] = new RecycleViewAdapter(words);
                recyclerView.setAdapter(a[0]);
            }
        });
    }

}