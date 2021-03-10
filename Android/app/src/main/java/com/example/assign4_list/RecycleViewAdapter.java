package com.example.assign4_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private String[] words;

    public RecycleViewAdapter(String[] words){
        this.words = words;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context c = parent.getContext();
        LayoutInflater li = LayoutInflater.from(c);
        View v = li.inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder holder, int position) {
        String s = words[position];
        TextView text = holder.text;
        text.setText(s);
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
