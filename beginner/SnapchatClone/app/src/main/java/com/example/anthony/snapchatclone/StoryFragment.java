package com.example.anthony.snapchatclone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anthony.snapchatclone.RecyclerViewFollow.FollowAdapter;
import com.example.anthony.snapchatclone.RecyclerViewFollow.FollowObject;

import java.util.ArrayList;

/**
 * Created by anthony on 3/24/18.
 */

public class StoryFragment extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static StoryFragment newInstance(){
        StoryFragment fragment = new StoryFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story , container,false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setHasFixedSize(false);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new FollowAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return view;

    }



    private void clear(){
        int size = this.results.size();
        this.results.clear();
        mAdapter.notifyItemRangeRemoved(0,size);
    }

    private ArrayList<FollowObject> results = new ArrayList<>();
    private ArrayList<FollowObject> getDataSet(){
        listenForData();
        return results;
    }

    private void listenForData() {
    }
}
