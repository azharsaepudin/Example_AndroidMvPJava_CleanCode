package com.azhar.androidmvpjava.ui.delete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.azhar.androidmvpjava.BaseApp;
import com.azhar.androidmvpjava.R;
import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.Service;

import javax.inject.Inject;

public class DeleteActivity extends BaseApp implements DeleteView {

    @Inject
    public Service service;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        getDeps().inject(this);

        deleteDataMhs();

    }

    private void deleteDataMhs(){

        DeletePresenter deletePresenter = new DeletePresenter(service, this);
        deletePresenter.deleteData("123");
    }

    @Override
    public void showWait() {

    }

    @Override
    public void removeWait() {

    }

    @Override
    public void onSuccessUpdate(CityListResponse cityListResponse) {

    }

    @Override
    public void onFailure(String appErrorMessage) {

    }
}
