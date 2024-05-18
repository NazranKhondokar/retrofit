package com.nazran.retrofit.network.service;

import com.google.gson.JsonObject;
import com.nazran.retrofit.network.response.EmployeeResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EmployeeApiInterface {
    @Headers("Content-Type: application/json")
    @GET("employee/details/")
    Call<EmployeeResponse> getEmployee(@Query("id") Long id);
}
