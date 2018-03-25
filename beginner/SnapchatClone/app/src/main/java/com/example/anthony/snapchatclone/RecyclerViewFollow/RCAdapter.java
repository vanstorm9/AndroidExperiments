package com.example.anthony.snapchatclone.RecyclerViewFollow;

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

public class RCAdapter extends RecyclerView.Adapter<RCViewHolders>{

    private List<UsersObject> usersList;
    private Context context;

    public RCAdapter (List<UsersObject> usersList, Context context){
        this.usersList = usersList;
        this.context = context;
    }
    @Override
    public RCViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_follows_item, null);
        RCViewHolders rcv = new RCViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final RCViewHolders holder, int position) {
        holder.mEmail.setText(usersList.get(position).getEmail());

        if(UserInformation.listFollowing.contains(usersList.get(holder.getLayoutPosition()).getUid())){
            holder.mFollow.setText("Following");
        }else{
            holder.mFollow.setText("Follow");
        }

        holder.mFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                if(!UserInformation.listFollowing.contains(usersList.get(holder.getLayoutPosition()).getUid())){
                    holder.mFollow.setText("Following");
                    FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("following").child(usersList.get(holder.getLayoutPosition()).getUid()).setValue(true);
                }else{
                    holder.mFollow.setText("Follow");
                    FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("following").child(usersList.get(holder.getLayoutPosition()).getUid()).removeValue();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }
}
