package com.example.assign4_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        Button commitTextButton = (Button) findViewById(R.id.button);
        TextView  textToCommit = (TextView) findViewById(R.id.textEntry);

        ArrayList<String> words = new ArrayList<>();

        words.add("dog");
        words.add("cat");
        words.add("horse");
        words.add("pig");
        words.add("sheep");
        words.add("giraffe");
        words.add("lion");

        words.sort((s1, s2) -> s1.compareTo(s2));

        final RecycleViewAdapter[] a = {new RecycleViewAdapter(words, recyclerView)};
        recyclerView.setAdapter(a[0]);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        commitTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                words.add(textToCommit.getText().toString());
                words.sort((s1, s2) -> s1.compareTo(s2));
                a[0] = new RecycleViewAdapter(words, recyclerView);
                recyclerView.setAdapter(a[0]);
            }
        });
    }

}