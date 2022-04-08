package com.codercamp.payertime.network;

import com.codercamp.payertime.model.DataModel;
import com.codercamp.payertime.model.Datetime;
import com.codercamp.payertime.model.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("times/today.json?city=dhaka-bd-bd-4933&school=2")
    Call<DataModel> getAllData();
}
