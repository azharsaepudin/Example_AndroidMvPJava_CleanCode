package com.azhar.androidmvpjava.ui.home;

import com.azhar.androidmvpjava.model.response.MhsListResponse;

public interface HomeView {

    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);
    void getCityListSuccess(MhsListResponse mhsListResponse);
}
