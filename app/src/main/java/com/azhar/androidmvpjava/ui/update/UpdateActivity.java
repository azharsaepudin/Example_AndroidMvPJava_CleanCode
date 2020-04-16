package com.azhar.androidmvpjava.ui.update;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.azhar.androidmvpjava.BaseApp;
import com.azhar.androidmvpjava.R;
import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.Service;

import javax.inject.Inject;

public class UpdateActivity extends BaseApp implements UpdateView {

    @Inject
    public Service service;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        getDeps().inject(this);

        updateDataMhs();
    }

    private void updateDataMhs(){

        UpdatePresenter updatePresenter = new UpdatePresenter(service, this);
        updatePresenter.updateData("123","azhar");

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
    public void updateDataSuccess(CityListResponse cityListResponse) {

    }
}
