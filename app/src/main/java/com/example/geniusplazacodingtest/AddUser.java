package com.example.geniusplazacodingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.geniusplazacodingtest.R;
import com.example.geniusplazacodingtest.api.RetrofitClient;
import com.example.geniusplazacodingtest.api.UserAPI;

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
        String first_name = first_name_edit_text.getText().toString();
        String last_name = last_name_edit_text.getText().toString();
        String email = email_edit_text.getText().toString();

        //Get the api client
        UserAPI service = RetrofitClient.getRetrofitClient().create(UserAPI.class);

        //TODO: Make a post call
        

    }
}
