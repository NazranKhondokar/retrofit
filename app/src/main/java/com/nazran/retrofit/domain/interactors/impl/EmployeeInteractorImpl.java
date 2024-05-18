package com.nazran.retrofit.domain.interactors.impl;

import android.util.Log;

import com.google.gson.JsonObject;
import com.nazran.retrofit.utils.Constants;
import com.nazran.retrofit.domain.executor.Executor;
import com.nazran.retrofit.domain.executor.MainThread;
import com.nazran.retrofit.domain.interactors.EmployeeInteractor;
import com.nazran.retrofit.domain.interactors.base.AbstractInteractor;
import com.nazran.retrofit.network.RetrofitApiClient;
import com.nazran.retrofit.network.response.EmployeeResponse;
import com.nazran.retrofit.network.service.EmployeeApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeInteractorImpl extends AbstractInteractor {
    private EmployeeInteractor.CallBack mCallback;
    private EmployeeApiInterface apiService;

    public EmployeeInteractorImpl(Executor threadExecutor, MainThread mainThread, EmployeeInteractor.CallBack callBack) {
        super(threadExecutor, mainThread);
        mCallback = callBack;
    }

    @Override
    public void run() {
        apiService = RetrofitApiClient.getClient().create(EmployeeApiInterface.class);

        Call<EmployeeResponse> call = apiService.getEmployee(1L);

        call.enqueue(new Callback<EmployeeResponse>() {
            @Override
            public void onResponse(Call<EmployeeResponse> call, Response<EmployeeResponse> response) {
                try {
                    assert response.body() != null;
                    Log.d("Test", response.body().getStatus());
                    mCallback.onEmployeeSuccess(response.body());
                } catch (Exception e) {
                    Log.e("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<EmployeeResponse> call, Throwable t) {
                Log.d("Test", String.valueOf(t.getMessage()));
                mCallback.onEmployeeError();
            }
        });
    }
}
