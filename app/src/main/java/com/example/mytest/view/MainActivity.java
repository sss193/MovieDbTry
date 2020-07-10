package com.example.mytest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytest.R;
import com.example.mytest.model.Movie;
import com.example.mytest.model.MovieRsponse;
import com.example.mytest.viewModel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView rv_movie_list;
    MovieViewModel movieViewModel;
    CustomAdapter customAdapter;
    List<Movie> movieList;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        rv_movie_list = (RecyclerView) findViewById(R.id.rv_movie_list);


        customAdapter = new CustomAdapter(MainActivity.this,movieList);
        rv_movie_list.setHasFixedSize(true);
        rv_movie_list.setLayoutManager(new GridLayoutManager(this, 2));
     //   rv_movie_list.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv_movie_list.setAdapter(customAdapter);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.init();



        inputSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    updateData(inputSearch.getText().toString());
                    //Toast.makeText(MainActivity.this, inputSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });


        inputSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (inputSearch.getRight() - inputSearch.getCompoundDrawables()
                            [DRAWABLE_RIGHT].getBounds().width())) {
                       // Toast.makeText(MainActivity.this, inputSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                        updateData(inputSearch.getText().toString());
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void updateData(String value){
        InputMethodManager imm = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(inputSearch.getWindowToken(), 0);
        dialog = ProgressDialog.show(this, "",
                "Loading. Please wait...", true);
        movieViewModel.getRowdata(value).observe(this, new Observer<MovieRsponse>() {
            @Override
            public void onChanged(MovieRsponse movieRsponse) {
                movieList = movieRsponse.getMovieList();
                customAdapter.setData(movieList);
                dialog.dismiss();
                dialog = null;
            }
        });
    }
}
