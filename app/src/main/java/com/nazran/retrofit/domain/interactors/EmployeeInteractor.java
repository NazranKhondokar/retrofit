package com.nazran.retrofit.domain.interactors;


import com.nazran.retrofit.network.response.EmployeeResponse;

public interface EmployeeInteractor {
    interface CallBack {

        void onEmployeeSuccess(EmployeeResponse employeeResponse);

        void onEmployeeError();
    }
}
