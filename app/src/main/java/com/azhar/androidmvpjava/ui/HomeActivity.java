package com.azhar.androidmvpjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.azhar.androidmvpjava.BaseApp;
import com.azhar.androidmvpjava.R;
import com.azhar.androidmvpjava.adapters.HomeAdapter;
import com.azhar.androidmvpjava.model.CityListData;
import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.Service;

import javax.inject.Inject;

public class HomeActivity extends BaseApp implements HomeView {

    @Inject
    public Service service;
    ProgressBar progressBar;

    RecyclerView rv_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDeps().inject(this);

        rv_list = findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));

        HomePresenter presenter = new HomePresenter(service, this);
        presenter.getCityList();
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
    public void getCityListSuccess(CityListResponse cityListResponse) {

        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), cityListResponse.getData(),
                new HomeAdapter.OnItemClickListener(){

                    @Override
                    public void onClick(CityListData Item) {
                        Toast.makeText(getApplicationContext(), Item.getName(),Toast.LENGTH_SHORT).show();
                    }
                });
        rv_list.setAdapter(adapter);
    }
}
