package com.example.assign4_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3 xml elements
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        Button commitTextButton = (Button) findViewById(R.id.addText);
        Button removeTextButton = (Button) findViewById(R.id.removeText);
        TextView  textToCommit = (TextView) findViewById(R.id.textEntry);

        //this will store all elements in the list
        ArrayList<String> words = new ArrayList<>();

        //populate with some default values
        words.add("dog");
        words.add("cat");
        words.add("horse");
        words.add("pig");
        words.add("sheep");
        words.add("giraffe");
        words.add("lion");

        //custom comparator to sort in alphabetical order
        words.sort((s1, s2) -> s1.compareTo(s2));

        //recycle view setup
        final RecycleViewAdapter[] a = {new RecycleViewAdapter(words, recyclerView)};//call my adapter with the arraylist and view
        //need list for elements, view for click handler
        recyclerView.setAdapter(a[0]);//set view and my adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //when add text button is pressed
        commitTextButton.setOnClickListener(v -> {
            words.add(textToCommit.getText().toString());//add user's entry to list
            words.sort((s1, s2) -> s1.compareTo(s2));//resort
            a[0] = new RecycleViewAdapter(words, recyclerView);//and re-add so that recycler shows changes
            recyclerView.setAdapter(a[0]);
        });


        removeTextButton.setOnClickListener(v -> {
            if(!words.remove(textToCommit.getText().toString())) {//remove user's entry to list
                Toast.makeText(this,textToCommit.getText().toString() + " is not in the list." , Toast.LENGTH_SHORT).show();
            }else {
                words.sort((s1, s2) -> s1.compareTo(s2));//resort
                a[0] = new RecycleViewAdapter(words, recyclerView);//and re-add so that recycler shows changes
                recyclerView.setAdapter(a[0]);
            }
        });
    }

}