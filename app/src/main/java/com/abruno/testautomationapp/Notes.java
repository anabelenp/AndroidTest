package com.abruno.testautomationapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static java.util.Collections.*;

public class Notes extends AppCompatActivity {

    private List<NotesBuilder> notesList = new ArrayList<>();
    private NotesAdapter nAdapter;
    private RecyclerView notesRecycler;
    private Bundle myBundle;
    SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Notes.this, EditNote.class);
                Notes.this.startActivity(myIntent);
                finish();
            }
        });

        prepareNotes();
        notesRecycler = (RecyclerView) findViewById(R.id.notes);
        notesRecycler.setLayoutManager(new LinearLayoutManager(this));
        nAdapter = new NotesAdapter(notesList);
        nAdapter.setOnEntryClickListener(new NotesAdapter.OnEntryClickListener() {
            @Override
            public void onEntryClick(View view, int position) {
                Context context = view.getContext();
                String title = ((TextView)view.findViewById(R.id.title)).getText().toString();
                Intent notesIntent = new Intent(context, EditNote.class);
                notesIntent.putExtra("title", title);
                context.startActivity(notesIntent);
                finish();
            }
        });
        //notesRecycler.setItemAnimator(new DefaultItemAnimator());
        notesRecycler.setAdapter(nAdapter);

    }

    private void prepareNotes() {
        File directory;
        directory = getFilesDir();
        File[] files = directory.listFiles();
        String theFile;
        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                String noteDate = (sdfDate.format(new Date(file.lastModified()))).toString();
                String noteTime = (sdfTime.format(new Date(file.lastModified()))).toString();
                NotesBuilder note = new NotesBuilder(file.getName().replaceAll("[.]+txt", ""), Open(file.getName()), noteDate, noteTime);
                notesList.add(note);
            }

        }
    }

    public String Open(String fileName) {
        String content = "";
        try {
            InputStream in = openFileInput(fileName);
            if ( in != null) {
                InputStreamReader tmp = new InputStreamReader( in );
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                } in .close();

                content = buf.toString();
            }
        } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

        return content;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent;
        switch (id){
            case R.id.sortAscendingByTitle:
                Collections.sort(notesList, (NotesBuilder n1, NotesBuilder n2) -> n1.getTitle().compareTo(n2.getTitle()));
                nAdapter.notifyDataSetChanged();
                return true;

            case R.id.sortDescendingByTitle:
                Collections.sort(notesList, (NotesBuilder n1, NotesBuilder n2) -> n2.getTitle().compareTo(n1.getTitle()));
                nAdapter.notifyDataSetChanged();
                return true;

            case R.id.sortAscendingByContent:
                Collections.sort(notesList, (NotesBuilder n1, NotesBuilder n2) -> n2.getContent().compareTo(n1.getContent()));
                nAdapter.notifyDataSetChanged();
                return true;

            case R.id.sortDescendingByContent:
                Collections.sort(notesList, (NotesBuilder n1, NotesBuilder n2) -> n1.getContent().compareTo(n2.getContent()));
                nAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void sortView(){
        Collections.sort(notesList, new Comparator<NotesBuilder>() {
            @Override
            public int compare(NotesBuilder notesBuilder1, NotesBuilder notesBuilder2) {
                return notesBuilder1.getTitle().compareTo(notesBuilder2.getTitle());
            }
        });
    }
}
