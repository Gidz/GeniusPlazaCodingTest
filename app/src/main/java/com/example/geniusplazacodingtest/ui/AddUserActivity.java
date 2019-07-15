package com.example.geniusplazacodingtest.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.geniusplazacodingtest.R;
import com.example.geniusplazacodingtest.api.ApiCallInterface;
import com.example.geniusplazacodingtest.di.ApiCallInterfaceComponent;
import com.example.geniusplazacodingtest.di.DaggerApiCallInterfaceComponent;
import com.example.geniusplazacodingtest.models.User;
import com.example.geniusplazacodingtest.viewmodels.AddUserActivityViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddUserActivity extends AppCompatActivity {

    private AddUserActivityViewModel addUserActivityViewModel;

    ApiCallInterfaceComponent apiCallInterfaceComponent;
    ApiCallInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        //Create and bind a view model
        addUserActivityViewModel = ViewModelProviders.of(this).get(AddUserActivityViewModel.class);
    }

    //Creates user
    public void createUser(View view) {

        //Extract the text from the view
        //By deafault, they'll be empty Strings
        EditText first_name_edit_text = findViewById(R.id.first_name);
        EditText last_name_edit_text = findViewById(R.id.last_name);
        EditText email_edit_text = findViewById(R.id.email);

        //Extarct the texts from the view
        String first_name = first_name_edit_text.getText().toString().trim();
        String last_name = last_name_edit_text.getText().toString().trim();
        String email = email_edit_text.getText().toString().trim();

        //Get the api client
        apiCallInterfaceComponent = DaggerApiCallInterfaceComponent.create();
        service = apiCallInterfaceComponent.getApiCallInterface();

        service.addUser(email, first_name, last_name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Toast.makeText(getApplicationContext(), R.string.user_added, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), R.string.error_message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
