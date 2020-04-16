package com.azhar.androidmvpjava.ui.update;

import com.azhar.androidmvpjava.model.response.CityListResponse;

public interface UpdateView {

    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);
    void updateDataSuccess(CityListResponse cityListResponse);

}
