package com.azhar.androidmvpjava.ui.update;

import com.azhar.androidmvpjava.model.response.MhsListResponse;

public interface UpdateView {

    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);
    void updateDataSuccess(MhsListResponse mhsListResponse);

}
