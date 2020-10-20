package com.abruno.testautomationapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter <NotesAdapter.MyViewHolder> {

private List <NotesBuilder> notesList;
private OnEntryClickListener onEntryClickListener;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView title, content, updatedDate, updatedTime;

    public MyViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        content = (TextView) view.findViewById(R.id.content);
        updatedDate = (TextView) view.findViewById(R.id.lastUpdatedDate);
        updatedTime = (TextView) view.findViewById(R.id.lastUpdatedTime);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (onEntryClickListener != null) {
            title = (TextView) view.findViewById(R.id.title);
            onEntryClickListener.onEntryClick(view, getLayoutPosition());
        }
    }
}

    public NotesAdapter(List <NotesBuilder> notesList) {
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NotesBuilder note = notesList.get(position);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());
        holder.updatedDate.setText(note.getUpdatedDate());
        holder.updatedTime.setText(note.getUpdatedTime());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }


    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }

    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        this.onEntryClickListener = onEntryClickListener;
    }
}
