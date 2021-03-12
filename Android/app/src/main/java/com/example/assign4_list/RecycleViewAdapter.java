package com.example.assign4_list;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private String[] words;
    private int indexInList = 0;
    private  String testStr;
    private RecyclerView recyclerView;


    public RecycleViewAdapter(String[] words, RecyclerView recyclerView){
        this.words = words;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context c = parent.getContext();
        LayoutInflater li = LayoutInflater.from(c);
        View v = li.inflate(R.layout.recyclerview_row, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int itemPosition = recyclerView.getChildLayoutPosition(view);
                //String item = words[itemPosition];


                //System.out.println("clicked on " + item);
                CharSequence text = "";
                if(itemPosition == 0){
                    text = words[itemPosition] + " is before all other words.";
                }else if(itemPosition == words.length-1){
                    text =words[itemPosition] + " is after all other words.";
                }else {
                    text = words[itemPosition] + " is before " + words[itemPosition + 1] + " and after " + words[itemPosition - 1];
                }
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(c, text, duration);
                //toast.setGravity(Gravity.TOP| Gravity.LEFT, 200, 200);
                toast.show();
            }
        });
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        String s = words[position];
        indexInList = position;
        TextView text = holder.text;
        text.setText(s);
        testStr = s;
        System.out.println("setting "+s+ "at "+position);
    }

    @Override
    public int getItemCount() {
        return words.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.rowEntry);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
