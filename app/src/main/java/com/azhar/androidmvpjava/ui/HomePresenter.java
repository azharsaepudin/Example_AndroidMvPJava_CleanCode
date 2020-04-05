package com.azhar.androidmvpjava.ui;

import com.azhar.androidmvpjava.model.response.CityListResponse;
import com.azhar.androidmvpjava.network.NetworkError;
import com.azhar.androidmvpjava.network.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class HomePresenter {

    private final Service service;
    private final HomeView homeView;
    private CompositeSubscription subscriptions;

    public HomePresenter(Service service, HomeView view){
        this.service = service;
        this.homeView = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCityList(){
        homeView.showWait();

        Subscription subscription = service.getCityList(new Service.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                homeView.removeWait();
                homeView.getCityListSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {

                homeView.removeWait();
                homeView.onFailure(networkError.getAppErrorMessage());

            }
        });

        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
