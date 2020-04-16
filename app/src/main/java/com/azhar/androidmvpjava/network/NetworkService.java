package com.azhar.androidmvpjava.network;

import com.azhar.androidmvpjava.model.response.CityListResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import rx.Observable;

public interface NetworkService {

    @GET("Get_mahasiswa")
    Observable<CityListResponse> getCityList();

    @FormUrlEncoded
    @POST("Input_mahasiswa")
    Observable<CityListResponse> inputData(
            @Field("npm") String npm,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @PUT("Update_mahasiswa")
    Observable<CityListResponse> updateData(
            @Field("npm") String npm,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @HTTP(method = "DELETE", path= "Delete_mahasiswa",hasBody = true)
    Observable<CityListResponse> deleteData(
      @Field("npm") String npm
    );

}
