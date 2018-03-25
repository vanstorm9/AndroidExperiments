package com.example.anthony.snapchatclone.RecyclerViewFollow;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.anthony.snapchatclone.R;

/**
 * Created by anthony on 3/24/18.
 */

public class RCViewHolders extends RecyclerView.ViewHolder{
    public TextView mEmail;
    public Button mFollow;

    public RCViewHolders(View itemView){
        super(itemView);
        mEmail = itemView.findViewById(R.id.email);
        mFollow = itemView.findViewById(R.id.follow);
    }
}
