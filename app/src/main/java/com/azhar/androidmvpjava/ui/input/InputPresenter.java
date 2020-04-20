package com.azhar.androidmvpjava.ui.input;

import com.azhar.androidmvpjava.model.response.MhsListResponse;
import com.azhar.androidmvpjava.network.NetworkError;
import com.azhar.androidmvpjava.network.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class InputPresenter {

    private final Service service;
    private final InputView inputView;
    private CompositeSubscription subscriptions;

    public InputPresenter(Service service, InputView view){
        this.service = service;
        this.inputView = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void inputData(String npm, String nama){
        inputView.showWait();

        Subscription subscription = service.inputData(npm, nama,new Service.InputDataCallback() {
            @Override
            public void onSuccessInput(MhsListResponse cityListResponse) {
                inputView.removeWait();;
                inputView.inputDataSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {

                inputView.removeWait();
                inputView.onFailure(networkError.getAppErrorMessage());
            }
        });

        subscriptions.add(subscription);
    }

    public void onStop(){
        subscriptions.unsubscribe();
    }
}
