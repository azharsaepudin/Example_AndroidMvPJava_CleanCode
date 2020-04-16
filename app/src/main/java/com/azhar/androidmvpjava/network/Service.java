package com.azhar.androidmvpjava.network;

import com.azhar.androidmvpjava.model.response.CityListResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Service {

    private final NetworkService networkService;

    public Service(NetworkService networkService){
        this.networkService = networkService;
    }

    public Subscription getCityList(final GetCityListCallback callback){

        return networkService.getCityList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CityListResponse>>() {
                    @Override
                    public Observable<? extends CityListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(CityListResponse cityListResponse) {
                        callback.onSuccess(cityListResponse);
                    }
                });
    }

    public Subscription inputData(String npm, String nama, final InputDataCallback callback){

        return networkService.inputData(npm,nama)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CityListResponse>>() {
                    @Override
                    public Observable<? extends CityListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(CityListResponse cityListResponse) {
                        callback.onSuccessInput(cityListResponse);
                    }
                });
    }

    public Subscription updateData(String npm, String nama, final  UpdateDataCallback callback){

        return networkService.updateData(npm,nama)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CityListResponse>>() {
                    @Override
                    public Observable<? extends CityListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(CityListResponse cityListResponse) {
                        callback.onSuccessUpdate(cityListResponse);
                    }
                });
    }

    public Subscription deleteData(String npm, final DeleteDataCallback callback){

        return networkService.deleteData(npm)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CityListResponse>>() {
                    @Override
                    public Observable<? extends CityListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);

                    }
                })
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(CityListResponse cityListResponse) {
                        callback.onSuccessDelete(cityListResponse);
                    }
                });
    }

    public interface GetCityListCallback {
        void onSuccess(CityListResponse cityListResponse);

        void onError(NetworkError networkError);
    }

    public interface InputDataCallback{
        void onSuccessInput(CityListResponse cityListResponse);

        void onError(NetworkError networkError);
    }

    public interface UpdateDataCallback{

        void onError(NetworkError networkError);

        void onSuccessUpdate(CityListResponse cityListResponse);
    }

    public interface DeleteDataCallback{

        void onError(NetworkError networkError);

        void onSuccessDelete(CityListResponse cityListResponse);
    }
}
