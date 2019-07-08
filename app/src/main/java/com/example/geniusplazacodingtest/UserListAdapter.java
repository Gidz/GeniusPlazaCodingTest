package com.example.geniusplazacodingtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geniusplazacodingtest.models.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder>{

    //We'll need context to render images with glide library and stuff like that
    Context context;

    //User data
    List<User> userData;

    //Constructor
    public UserListAdapter(Context context, List<User> userData) {
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public static class UserListViewHolder extends RecyclerView.ViewHolder{
        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
