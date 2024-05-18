package com.nazran.retrofit.presentation.ui.activities.impl;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nazran.retrofit.R;
import com.nazran.retrofit.domain.executor.impl.ThreadExecutor;
import com.nazran.retrofit.network.response.EmployeeResponse;
import com.nazran.retrofit.presentation.presenters.EmployeePresenter;
import com.nazran.retrofit.presentation.ui.activities.EmployeeView;
import com.nazran.retrofit.threading.MainThreadImpl;
import com.nazran.retrofit.utils.Constants;

public class EmployeeActivity extends AppCompatActivity implements EmployeeView {

    private static final String TAG = EmployeeActivity.class.getSimpleName();
    private Context context = EmployeeActivity.this;
    private ProgressBar progressBarEmployee;
    private TextView employeeTitle, employeeDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        initViews();
        if (Constants.isNetworkAvailable(context)) {
            progressBarEmployee.setVisibility(View.VISIBLE);
            new EmployeePresenter(ThreadExecutor.getInstance(), MainThreadImpl.getInstance(),
                    EmployeeActivity.this).getEmployee();
        }
    }

    private void initViews() {
        progressBarEmployee = findViewById(R.id.progressBarEmployee);
        employeeTitle = findViewById(R.id.employeeTitle);
        employeeDescription = findViewById(R.id.employeeDescription);
    }


    @Override
    public void setEmployeeResponse(EmployeeResponse employeeResponse) {
        progressBarEmployee.setVisibility(View.INVISIBLE);
        if (employeeResponse.getStatus().equals("success")) {
            Log.d("name", ":: " + employeeResponse.getData().getEmployeeName());
            Log.d("nameBn", ":: " + employeeResponse.getData().getEmployeeNameBn());

            employeeTitle.setText(employeeResponse.getData().getEmployeeName());
            employeeDescription.setText(employeeResponse.getData().getEmployeeNameBn());
        }
    }
}