package com.azhar.androidmvpjava.di;

import com.azhar.androidmvpjava.network.NetworkModule;
import com.azhar.androidmvpjava.ui.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface Deps {

    void inject(HomeActivity homeActivity);

}
