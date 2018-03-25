package com.example.anthony.snapchatclone.RecycleViewStory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anthony.snapchatclone.R;
import com.example.anthony.snapchatclone.UserInformation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by anthony on 3/24/18.
 */

public class StoryAdapter extends RecyclerView.Adapter<StoryViewHolders>{

    private List<StoryObject> usersList;
    private Context context;

    public StoryAdapter(List<StoryObject> usersList, Context context){
        this.usersList = usersList;
        this.context = context;
    }
    @Override
    public StoryViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_story_item, null);
        StoryViewHolders rcv = new StoryViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final StoryViewHolders holder, int position) {
        holder.mEmail.setText(usersList.get(position).getEmail());
        holder.mEmail.setTag(usersList.get(position).getUid());
    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }
}
