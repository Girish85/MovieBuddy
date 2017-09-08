package com.example.usgir.moviebuddy;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by usgir on 8/13/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<Myholder> {
    ArrayList<String> titles,ratings,views,pics;
    Context c;
    LayoutInflater inflater;
    public MovieAdapter(Context context,ArrayList<String> t,ArrayList<String> r,ArrayList<String> v,ArrayList<String> p) {
        c = context;
        titles = t;
        ratings = r;
        views = v;
        pics = p;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem,parent,false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.noview.setText(views.get(position));
        holder.norating.setText(ratings.get(position));
        float i = Float.parseFloat(ratings.get(position));
        holder.ratingbar.setRating(i/2);
        Uri uri = Uri.parse(pics.get(position));
        Picasso.with(c).load(uri).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
}
class Myholder extends RecyclerView.ViewHolder
{
    ImageView pic;
    TextView title,norating,noview;
    RatingBar ratingbar;
    public Myholder(View itemView) {
        super(itemView);
        pic = (ImageView)itemView.findViewById(R.id.imageView);
        title = (TextView)itemView.findViewById(R.id.title);
        norating = (TextView)itemView.findViewById(R.id.norating);
        noview = (TextView)itemView.findViewById(R.id.noviews);
        ratingbar = (RatingBar)itemView.findViewById(R.id.ratingBar);
    }
}
