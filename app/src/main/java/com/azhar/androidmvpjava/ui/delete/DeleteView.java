package com.azhar.androidmvpjava.ui.delete;

import com.azhar.androidmvpjava.model.response.MhsListResponse;

public interface DeleteView {

    void showWait();
    void removeWait();
    void onSuccessUpdate(MhsListResponse mhsListResponse);
    void onFailure(String appErrorMessage);
}
