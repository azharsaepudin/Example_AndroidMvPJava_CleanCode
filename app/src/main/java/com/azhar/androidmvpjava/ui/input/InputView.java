package com.azhar.androidmvpjava.ui.input;

import com.azhar.androidmvpjava.model.response.MhsListResponse;

public interface InputView {

    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);
    void inputDataSuccess(MhsListResponse mhsListResponse);

}
