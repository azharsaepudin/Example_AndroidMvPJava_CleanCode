package com.azhar.androidmvpjava.ui.delete;

import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.NetworkError;
import com.azhar.androidmvpjava.network.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class DeletePresenter {

    private final Service service;
    private final DeleteView deleteView;
    private CompositeSubscription subscriptions;

    public DeletePresenter(Service service, DeleteView deleteView){
        this.service = service;
        this.deleteView = deleteView;
        this.subscriptions = new CompositeSubscription();
    }

    public void deleteData(String npm){

        deleteView.showWait();

        Subscription subscription = service.deleteData(npm,new Service.DeleteDataCallback() {
            @Override
            public void onError(NetworkError networkError) {

                deleteView.removeWait();
                deleteView.onFailure(networkError.getAppErrorMessage());
            }

            @Override
            public void onSuccessDelete(CityListResponse cityListResponse) {
                deleteView.removeWait();
                deleteView.onSuccessUpdate(cityListResponse);
            }
        });

        subscriptions.add(subscription);
    }
}
