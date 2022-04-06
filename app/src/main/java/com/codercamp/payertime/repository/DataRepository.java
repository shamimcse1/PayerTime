package com.codercamp.payertime.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.codercamp.payertime.helper.DataResource;
import com.codercamp.payertime.model.DataModel;
import com.codercamp.payertime.network.ApiInterface;
import com.codercamp.payertime.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    ApiInterface apiInterface;

    private final MutableLiveData<DataResource<DataModel>> mutableLiveData = new MutableLiveData<>();
    public LiveData<DataResource<DataModel>> dataResourceLiveData = mutableLiveData;

    public void GetData() {
        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);

        Call<DataModel> call = apiInterface.getAllData();
        mutableLiveData.postValue(DataResource.loading());
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.code() == 200 && response.body() != null) {
                    mutableLiveData.postValue(DataResource.success(response.body()));
                } else {
                    mutableLiveData.postValue(DataResource.error(response.message()));
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                mutableLiveData.postValue(DataResource.error(t.getMessage()));
            }
        });
    }
}
