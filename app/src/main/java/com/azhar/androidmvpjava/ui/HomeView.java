package com.azhar.androidmvpjava.ui;

import com.azhar.androidmvpjava.model.response.CityListResponse;

public interface HomeView {

    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);
    void getCityListSuccess(CityListResponse cityListResponse);
}
