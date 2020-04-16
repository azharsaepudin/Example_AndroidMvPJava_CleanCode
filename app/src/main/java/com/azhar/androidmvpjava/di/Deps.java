package com.azhar.androidmvpjava.di;

import com.azhar.androidmvpjava.network.NetworkModule;
import com.azhar.androidmvpjava.ui.delete.DeleteActivity;
import com.azhar.androidmvpjava.ui.home.HomeActivity;
import com.azhar.androidmvpjava.ui.input.InputActivity;
import com.azhar.androidmvpjava.ui.update.UpdateActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface Deps {

    void inject(HomeActivity homeActivity);
    void inject(InputActivity inputActivity);
    void inject(UpdateActivity updateActivity);
    void inject(DeleteActivity deleteActivity);
}
