package com.azhar.androidmvpjava.network;

import com.azhar.androidmvpjava.model.response.CityListResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();
}
