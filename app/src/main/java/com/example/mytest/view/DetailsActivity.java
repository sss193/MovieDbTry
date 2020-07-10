package com.example.mytest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytest.R;
import com.example.mytest.common.AppConstant;
import com.example.mytest.model.MovieDetailsResponse;
import com.example.mytest.viewModel.MovieDetailsViewModel;
import com.example.mytest.viewModel.MovieViewModel;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
String movie_id;
    MovieDetailsViewModel movieDetailsViewModel;
    CustomAdapter customAdapter;
        MovieDetailsResponse movieDetailsData;
    ProgressDialog dialog;
    TextView tv_movie_year,tv_movie_title,tv_director,tv_writer,tv_Author;
    ImageView iv_poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tv_movie_year = (TextView) findViewById(R.id.tv_movie_year);
        tv_movie_title = (TextView) findViewById(R.id.tv_movie_title);
        iv_poster = (ImageView) findViewById(R.id.iv_poster);

        tv_director = (TextView) findViewById(R.id.tv_director);
        tv_writer = (TextView) findViewById(R.id.tv_writer);
        tv_Author = (TextView) findViewById(R.id.tv_Author);


        movie_id = getIntent().getExtras().getString(AppConstant.MOVIE_ID);
        movieDetailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel.class);
        dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        movieDetailsViewModel.init(movie_id).observe(this, new Observer<MovieDetailsResponse>() {
            @Override
            public void onChanged(MovieDetailsResponse movieDetailsResponse) {
                movieDetailsData = movieDetailsResponse;
                if(null!=movieDetailsData)
                    updateView();
                dialog.dismiss();
                dialog = null;
            }
        });
    }

    private void updateView() {
        tv_movie_title.setText(movieDetailsData.getTitle());
        tv_movie_year.setText(movieDetailsData.getYear());
        Picasso.get()
                .load(movieDetailsData.getPoster())
                .fit()
                .into(iv_poster);

        tv_director.setText("Director: "+movieDetailsData.getDirector());
        tv_writer.setText("Writer: "+movieDetailsData.getWriter());
        tv_Author.setText("Actors: "+movieDetailsData.getActors());

    }

}
