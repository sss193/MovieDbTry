package com.example.mytest.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytest.common.AppConstant;
import com.example.mytest.model.DemoRepository;
import com.example.mytest.model.MovieRsponse;

public class MovieViewModel extends ViewModel {

    private MutableLiveData<MovieRsponse> mutableLiveData;
    private DemoRepository demoRepository;

    public void init(){
        demoRepository = DemoRepository.getInstance();
    }

    public LiveData<MovieRsponse> getRowdata(String value) {
        mutableLiveData = demoRepository.getRowList(AppConstant.API_KEY,value,AppConstant.TYPE);
        return mutableLiveData;
    }

}
