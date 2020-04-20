package com.azhar.androidmvpjava.network;

import com.azhar.androidmvpjava.model.response.MhsListResponse;

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
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MhsListResponse>>() {
                    @Override
                    public Observable<? extends MhsListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MhsListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(MhsListResponse mhsListResponse) {
                        callback.onSuccess(mhsListResponse);
                    }
                });
    }

    public Subscription inputData(String npm, String nama, final InputDataCallback callback){

        return networkService.inputData(npm,nama)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MhsListResponse>>() {
                    @Override
                    public Observable<? extends MhsListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MhsListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(MhsListResponse mhsListResponse) {
                        callback.onSuccessInput(mhsListResponse);
                    }
                });
    }

    public Subscription updateData(String npm, String nama, final  UpdateDataCallback callback){

        return networkService.updateData(npm,nama)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MhsListResponse>>() {
                    @Override
                    public Observable<? extends MhsListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MhsListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(MhsListResponse mhsListResponse) {
                        callback.onSuccessUpdate(mhsListResponse);
                    }
                });
    }

    public Subscription deleteData(String npm, final DeleteDataCallback callback){

        return networkService.deleteData(npm)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MhsListResponse>>() {
                    @Override
                    public Observable<? extends MhsListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);

                    }
                })
                .subscribe(new Subscriber<MhsListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(MhsListResponse mhsListResponse) {
                        callback.onSuccessDelete(mhsListResponse);
                    }
                });
    }

    public interface GetCityListCallback {
        void onSuccess(MhsListResponse mhsListResponse);

        void onError(NetworkError networkError);
    }

    public interface InputDataCallback{
        void onSuccessInput(MhsListResponse mhsListResponse);

        void onError(NetworkError networkError);
    }

    public interface UpdateDataCallback{

        void onError(NetworkError networkError);

        void onSuccessUpdate(MhsListResponse mhsListResponse);
    }

    public interface DeleteDataCallback{

        void onError(NetworkError networkError);

        void onSuccessDelete(MhsListResponse mhsListResponse);
    }
}
