package com.example.geniusplazacodingtest.ui;

import android.content.Intent;
import android.os.Bundle;

import com.example.geniusplazacodingtest.R;
import com.example.geniusplazacodingtest.adapters.UserListAdapter;
import com.example.geniusplazacodingtest.api.RetrofitClient;
import com.example.geniusplazacodingtest.api.ApiCallInterface;
import com.example.geniusplazacodingtest.models.JsonResponse;
import com.example.geniusplazacodingtest.models.User;
import com.example.geniusplazacodingtest.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userListView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter userListAdapter;
    private JsonResponse jsonData;

    private MainActivityViewModel mainActivityViewModel;

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

        //Create a view model
        //Bind the view model
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        //Download the json data
        //Get the data from the API
        ApiCallInterface service = RetrofitClient.getRetrofitClient().create(ApiCallInterface.class);

        Call<JsonResponse> call = service.getData();

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                //Display the recyvler with the downloaded data
                //Make sure to pass in only user data and not the original json response
                displayRecyclerView(response.body().getData());
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                //Display an error snackbar
                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.main_coordinator_layout),
                        R.string.error_message, Snackbar.LENGTH_LONG);
                mySnackbar.show();
            }
        });

    }

    private void displayRecyclerView(List<User> userData)
    {
        //Initialize Recycler View
        userListView = (RecyclerView) findViewById(R.id.user_list);
        layoutManager = new LinearLayoutManager(this);

        userListAdapter = new UserListAdapter(this, userData);

        //Set the adapter
        userListView.setAdapter(userListAdapter);

        //Use the linear layout manager
        userListView.setLayoutManager(layoutManager);
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
