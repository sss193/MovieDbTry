package com.example.mytest.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mytest.R;
import com.example.mytest.common.AppConstant;
import com.example.mytest.model.Movie;
import com.example.mytest.model.MovieRsponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public  class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Movie> rowResponses;
    Context context;
    public CustomAdapter(Context context, List<Movie> rowResponses ) {
        this.context = context;
        this.rowResponses = rowResponses;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        if(null != rowResponses.get(position).getTitle()){
            holder.title.setText(rowResponses.get(position).getTitle());
        }

        if(null != rowResponses.get(position).getPoster())
            Picasso.get()
                    .load(rowResponses.get(position).getPoster())
                    .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,DetailsActivity.class);
                i.putExtra(AppConstant.MOVIE_ID,rowResponses.get(position).getImdbID());
                context.startActivity(i);
            }
        });


    }
    @Override
    public int getItemCount() {
        if(null != rowResponses)
            return rowResponses.size();
        else
            return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_movie);
            image = (ImageView) itemView.findViewById(R.id.iv_movie);
            ll = (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }
    public void setData(List<Movie> rowResponses) {
        this.rowResponses = rowResponses;
        this.notifyDataSetChanged();
    }
}
