package com.example.geniusplazacodingtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.geniusplazacodingtest.R;
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
        //Get the layout inflater
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //Inflate the user item view
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);
        //Return this view
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        String fullName = userData.get(position).getFirst_name() +" "+userData.get(position).getLast_name();
        holder.userName.setText(fullName);
        //Display image with glide
        Glide.with(context).load(userData.get(position).getAvatar()).override(150,150).into(holder.userImage);

    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public static class UserListViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        ImageView userImage;

        public UserListViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userImage = itemView.findViewById(R.id.user_image);
        }
    }
}
