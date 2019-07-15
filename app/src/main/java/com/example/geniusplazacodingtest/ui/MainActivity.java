package com.example.geniusplazacodingtest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.geniusplazacodingtest.R;
import com.example.geniusplazacodingtest.adapters.UserListAdapter;
import com.example.geniusplazacodingtest.models.JsonResponse;
import com.example.geniusplazacodingtest.models.User;
import com.example.geniusplazacodingtest.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userListView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter userListAdapter;
    private JsonResponse jsonData;

    private MainActivityViewModel mainActivityViewModel;

    private MutableLiveData<ArrayList<User>> userDataMutableLiveData;

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Launch CreateUser Activity when this button is clicked
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Launch CreateUser Activity
                Intent i = new Intent(view.getContext(), AddUser.class);
                startActivity(i);
            }
        });

        Log.e(TAG,"Created activity");

        //Create and bind a view model
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        userDataMutableLiveData = mainActivityViewModel.getUserDataMutableLiveData();


        userDataMutableLiveData.observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                displayRecyclerView(users);
            }
        });
    }

    private void displayRecyclerView(ArrayList<User> userData)
    {
        //Initialize Recycler View
        userListView = findViewById(R.id.user_list);
        layoutManager = new LinearLayoutManager(this);

        userListAdapter = new UserListAdapter(this, userData);

        //Set the adapter
        userListView.setAdapter(userListAdapter);

        //Use the linear layout manager
        userListView.setLayoutManager(layoutManager);
    }

}
