package com.nazran.retrofit.network.service;

import com.nazran.retrofit.network.response.EmployeeResponse;
import com.nazran.retrofit.network.response.StatusResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EmployeeApiInterface {

    @GET("employee/details")
    Call<EmployeeResponse> getEmployee(@Query("id") Long id);
    @GET("check/status")
    Call<StatusResponse> getStatus();
}
