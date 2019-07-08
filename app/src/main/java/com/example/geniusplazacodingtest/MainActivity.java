package com.example.geniusplazacodingtest;

import android.os.Bundle;

import com.example.geniusplazacodingtest.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userListView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter userListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Initialize Recycler View
        userListView = (RecyclerView) findViewById(R.id.user_list);
        layoutManager = new LinearLayoutManager(this);

        //TODO: Send in actual data instead of null
        userListAdapter = new UserListAdapter(this, getFakeData());

        //Set the adapter
        userListView.setAdapter(userListAdapter);

        //Use the linear layout manager
        userListView.setLayoutManager(layoutManager);
    }

    private List<User> getFakeData()
    {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(0, "gidzpaul95@gmail.com", "Gideon", "Paul", "Duh"));
        userList.add(new User(1, "dozwert@gmail.com", "Ritchie", "Shelson", "Don't Care"));
        userList.add(new User(2, "rebekah@gmail.com", "Rebekah", "Paul", "Spice"));
        userList.add(new User(3, "olivia@gmail.com", "Olivia", "Dozwert", "Sassy"));
        return userList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
