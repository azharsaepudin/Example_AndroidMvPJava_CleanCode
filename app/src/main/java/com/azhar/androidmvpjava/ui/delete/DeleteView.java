package com.azhar.androidmvpjava.ui.delete;

import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.NetworkError;

public interface DeleteView {

    void showWait();
    void removeWait();
    void onSuccessUpdate(CityListResponse cityListResponse);
    void onFailure(String appErrorMessage);
}
