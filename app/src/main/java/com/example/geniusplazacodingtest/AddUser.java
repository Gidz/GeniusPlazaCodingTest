package com.example.geniusplazacodingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geniusplazacodingtest.R;
import com.example.geniusplazacodingtest.api.RetrofitClient;
import com.example.geniusplazacodingtest.api.UserAPI;
import com.example.geniusplazacodingtest.models.User;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    //Creates user
    public void createUser(View view) {

        //Extract the text from the view
        //By deafault, they'll be empty Strings
        EditText first_name_edit_text = (EditText) findViewById(R.id.first_name);
        EditText last_name_edit_text = (EditText) findViewById(R.id.last_name);
        EditText email_edit_text = (EditText) findViewById(R.id.email);

        //Extarct the texts from the view
        String first_name = first_name_edit_text.getText().toString().trim();
        String last_name = last_name_edit_text.getText().toString().trim();
        String email = email_edit_text.getText().toString().trim();

        //Get the api client
        UserAPI service = RetrofitClient.getRetrofitClient().create(UserAPI.class);

        //Note : This is the most simplistic implementation
        service.addUser(email,first_name,last_name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), R.string.user_added, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.error_message, Toast.LENGTH_LONG).show();
            }
        });

    }
}
