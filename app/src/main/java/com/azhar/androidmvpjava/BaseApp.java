package com.azhar.androidmvpjava;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.azhar.androidmvpjava.di.Deps;
import com.azhar.androidmvpjava.di.DaggerDeps;
import com.azhar.androidmvpjava.network.NetworkModule;

import java.io.File;

public class BaseApp extends AppCompatActivity {

    Deps deps;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "response");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();


    }
    public Deps getDeps(){
        return deps;
    }
}
