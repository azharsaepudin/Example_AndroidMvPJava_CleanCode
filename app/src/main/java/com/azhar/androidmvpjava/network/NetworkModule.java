package com.azhar.androidmvpjava.network;

import com.azhar.androidmvpjava.BuildConfig;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


@Module
public class NetworkModule {

    File cacheFile;

    public NetworkModule(File cacheFile){
        this.cacheFile = cacheFile;
    }


    @Provides
    @Singleton
    Retrofit provideVAll(){
        Cache cache = null;

        try{

            cache = new Cache(cacheFile, 10 * 1024 * 1024);


        }catch (Exception e){
            e.printStackTrace();
        }


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().cache(cache);
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public NetworkService provideNetworkService(Retrofit retrofit){

        return retrofit.create(NetworkService.class);
    }

    @Provides
    @Singleton
    public Service prividesService(NetworkService networkService){
        return new Service(networkService);
    }

}
