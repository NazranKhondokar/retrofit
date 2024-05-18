package com.nazran.retrofit.presentation.presenters;

import com.nazran.retrofit.domain.executor.Executor;
import com.nazran.retrofit.domain.executor.MainThread;
import com.nazran.retrofit.domain.interactors.EmployeeInteractor;
import com.nazran.retrofit.domain.interactors.impl.EmployeeInteractorImpl;
import com.nazran.retrofit.network.response.EmployeeResponse;
import com.nazran.retrofit.presentation.ui.activities.EmployeeView;

public class EmployeePresenter extends AbstractPresenter implements EmployeeInteractor.CallBack{

    private EmployeeView employeeView;

    public EmployeePresenter(Executor executor, MainThread mainThread, EmployeeView employeeView) {
        super(executor, mainThread);
        this.employeeView = employeeView;
    }

    public void getEmployee() {
        new EmployeeInteractorImpl(mExecutor, mMainThread, this).execute();
    }

    @Override
    public void onEmployeeSuccess(EmployeeResponse employeeResponse) {
        if (employeeView != null){
            employeeView.setEmployeeResponse(employeeResponse);
        }
    }

    @Override
    public void onEmployeeError() {

    }
}
