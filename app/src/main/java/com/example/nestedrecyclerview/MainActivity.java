package com.example.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ParentModelClass> parentModelClassArrayList;
    ArrayList<ChildModelClass> childModelClassArrayList;
    ArrayList<ChildModelClass> favoriteList;
    ArrayList<ChildModelClass> recentlyWatchedList;
    ArrayList<ChildModelClass> latestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.parent_rv);
        parentModelClassArrayList = new ArrayList<>();
        childModelClassArrayList = new ArrayList<>();
        favoriteList = new ArrayList<>();
        recentlyWatchedList = new ArrayList<>();
        latestList = new ArrayList<>();
        ParentAdapter parentAdapter;

        latestList.add(new ChildModelClass(R.drawable.r));
        latestList.add(new ChildModelClass(R.drawable.e));
        latestList.add(new ChildModelClass(R.drawable.b));
        latestList.add(new ChildModelClass(R.drawable.c));
        latestList.add(new ChildModelClass(R.drawable.h));
        latestList.add(new ChildModelClass(R.drawable.m));
        latestList.add(new ChildModelClass(R.drawable.n));
        latestList.add(new ChildModelClass(R.drawable.o));
        latestList.add(new ChildModelClass(R.drawable.w));
        latestList.add(new ChildModelClass(R.drawable.y));
        latestList.add(new ChildModelClass(R.drawable.z));

        parentModelClassArrayList.add(new ParentModelClass("Latest Movies",latestList));

        recentlyWatchedList.add(new ChildModelClass(R.drawable.q));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.r));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.e));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.v));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.y));
        recentlyWatchedList.add(new ChildModelClass(R.drawable.z));

        parentModelClassArrayList.add(new ParentModelClass("Recently Watched",recentlyWatchedList));

        favoriteList.add(new ChildModelClass(R.drawable.q));
        favoriteList.add(new ChildModelClass(R.drawable.r));
        favoriteList.add(new ChildModelClass(R.drawable.e));
        favoriteList.add(new ChildModelClass(R.drawable.v));
        favoriteList.add(new ChildModelClass(R.drawable.y));
        favoriteList.add(new ChildModelClass(R.drawable.z));

        parentModelClassArrayList.add(new ParentModelClass("Favorites",favoriteList));


        childModelClassArrayList.clear();
        childModelClassArrayList.add(new ChildModelClass(R.drawable.r));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.e));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.b));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.c));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.h));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.m));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.n));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.o));
        childModelClassArrayList.add(new ChildModelClass(R.drawable.w));

        parentModelClassArrayList.add(new ParentModelClass("Recently",childModelClassArrayList));
        parentModelClassArrayList.add(new ParentModelClass("Recently",childModelClassArrayList));
        parentModelClassArrayList.add(new ParentModelClass("Great", childModelClassArrayList));
        parentModelClassArrayList.add(new ParentModelClass("Fine",childModelClassArrayList));
        parentModelClassArrayList.add(new ParentModelClass("Recently",childModelClassArrayList));

        parentAdapter = new ParentAdapter(parentModelClassArrayList,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();


    }
}