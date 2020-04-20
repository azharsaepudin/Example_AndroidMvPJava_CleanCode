package com.azhar.androidmvpjava.ui.input;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.azhar.androidmvpjava.BaseApp;
import com.azhar.androidmvpjava.R;
import com.azhar.androidmvpjava.model.response.MhsListResponse;
import com.azhar.androidmvpjava.network.Service;

import javax.inject.Inject;

public class InputActivity extends BaseApp implements InputView {

    @Inject
    public Service service;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        getDeps().inject(this);



        inputDataMhs();
    }


    private void inputDataMhs(){

        InputPresenter presenter = new InputPresenter(service, this);
        presenter.inputData("123","asep");

    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void inputDataSuccess(MhsListResponse mhsListResponse) {

    }
}
