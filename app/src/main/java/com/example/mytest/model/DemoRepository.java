package com.example.mytest.model;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DemoRepository {
    private static DemoRepository demoRepository;
    private ApiInterface apiInterface;

    public static DemoRepository getInstance(){
        if (demoRepository == null){
            demoRepository = new DemoRepository();
        }
        return demoRepository;
    }



    public DemoRepository(){
        apiInterface = RetrofitService.cteateService(ApiInterface.class);
    }

    public MutableLiveData<MovieRsponse> getRowList(String apikey,String value,String type){
        final MutableLiveData<MovieRsponse> rowListData = new MutableLiveData<>();
        apiInterface.getMovieList(apikey,value,type).enqueue(new Callback<MovieRsponse>() {
            @Override
            public void onResponse(Call<MovieRsponse> call,
                                   Response<MovieRsponse> response) {
                if (response.isSuccessful()){
                    rowListData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieRsponse> call, Throwable t) {
                rowListData.setValue(null);
            }
        });
        return rowListData;
    }

    public MutableLiveData<MovieDetailsResponse> getMovieDetails(String apikey,String value){
        final MutableLiveData<MovieDetailsResponse> mvDetails = new MutableLiveData<>();
        apiInterface.getMovieDetails(apikey,value).enqueue(new Callback<MovieDetailsResponse>() {
            @Override
            public void onResponse(Call<MovieDetailsResponse> call,
                                   Response<MovieDetailsResponse> response) {
                if (response.isSuccessful()){
                    mvDetails.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieDetailsResponse> call, Throwable t) {
                mvDetails.setValue(null);
            }
        });
        return mvDetails;
    }
}
