package com.azhar.androidmvpjava.ui.update;

import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.NetworkError;
import com.azhar.androidmvpjava.network.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class UpdatePresenter {

    private final Service service;
    private final UpdateView updateView;
    private CompositeSubscription subscriptions;

    public UpdatePresenter(Service service, UpdateView updateView){
        this.service = service;
        this.updateView = updateView;
        this.subscriptions = new CompositeSubscription();
    }

    public void updateData(String npm, String nama){

        updateView.showWait();

        Subscription subscription = service.updateData(npm, nama, new Service.UpdateDataCallback() {
            @Override
            public void onError(NetworkError networkError) {

                updateView.removeWait();
                updateView.onFailure(networkError.getAppErrorMessage());
            }

            @Override
            public void onSuccessUpdate(CityListResponse cityListResponse) {

                updateView.removeWait();
                updateView.updateDataSuccess(cityListResponse);

            }
        });

        subscriptions.add(subscription);
    }

    public void onStop(){
        subscriptions.unsubscribe();
    }
}
