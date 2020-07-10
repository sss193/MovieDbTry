package com.example.mytest.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytest.common.AppConstant;
import com.example.mytest.model.DemoRepository;
import com.example.mytest.model.MovieDetailsResponse;

public class MovieDetailsViewModel extends ViewModel {

    private MutableLiveData<MovieDetailsResponse> mutableLiveData;
    private DemoRepository demoRepository;

    public LiveData<MovieDetailsResponse>  init(String value){
        demoRepository = DemoRepository.getInstance();
        mutableLiveData = demoRepository.getMovieDetails(AppConstant.API_KEY,value);
        return mutableLiveData;
    }

}
