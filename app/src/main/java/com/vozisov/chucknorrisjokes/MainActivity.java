package com.vozisov.chucknorrisjokes;

import static com.vozisov.chucknorrisjokes.config.Config.getAPICategory;
import static com.vozisov.chucknorrisjokes.config.Config.getAPIJokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vozisov.chucknorrisjokes.config.API;
import com.vozisov.chucknorrisjokes.model.Joke;
import com.vozisov.chucknorrisjokes.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList categoryList;
    Joke mJoke;

    RelativeLayout container;
    TextView value;
    ImageView icon;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);
        value = findViewById(R.id.value);
        icon = findViewById(R.id.icon);
        refresh = findViewById(R.id.refresh);

        if (Utils.isOnline(getApplicationContext())) {
            getJoke();
            getCategoryList();
        }
    }

    private void setUI() {

        container.setVisibility(View.VISIBLE);

        value.setText(mJoke.getValue());

        Picasso.get()
                .load(mJoke.getIconUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(icon);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Utils.isOnline(getApplicationContext())) {
                    getJoke();
                    setUI();
                }
            }
        });

    }

    private void getJoke() {

        API api = getAPIJokes();

        Call<Joke> jokeCall = api.getJoke();

        jokeCall.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {

                if (response.isSuccessful()) {
                    mJoke = response.body();
                    setUI();
                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
            }
        });
    }

    private void getCategoryList() {

        API api = getAPICategory();

        Call<String> categoriesCall = api.getCategories();

        categoriesCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()) {

                    try {
                        categoryList = Utils.convertToArrayList(new JSONArray(response.body()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }
}
