package com.example.usgir.moviebuddy;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    ArrayList<String> titles,ratings,views,pics;
    String title,rating,view,pic;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout)findViewById(R.id.relative);
        recyclerView = (RecyclerView)findViewById(R.id.cycler);
        titles = new ArrayList<>();
        ratings = new ArrayList<>();
        views = new ArrayList<>();
        pics = new ArrayList<>();
        adapter = new MovieAdapter(getApplicationContext(),titles,ratings,views,pics);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.themoviedb.org/3/discover/movie?api_key=4052692cb1498821bc2c6abda8f3b69f&sort_by=vote_average.desc&vote_count.gte=1000", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                for (int i = 0;i<10;i++)
                {
                try {
                    title = response.getJSONArray("results").getJSONObject(i).getString("title");
                    rating = response.getJSONArray("results").getJSONObject(i).getString("vote_average");
                    view = response.getJSONArray("results").getJSONObject(i).getString("vote_count");
                    pic = "https://image.tmdb.org/t/p/w500"+response.getJSONArray("results").getJSONObject(i).getString("poster_path");
                    titles.add(title);
                    ratings.add(rating);
                    views.add(view);
                    pics.add(pic);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                }
                Snackbar.make(relativeLayout,"Displaying Movies",Snackbar.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(relativeLayout,error.toString(),Snackbar.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
