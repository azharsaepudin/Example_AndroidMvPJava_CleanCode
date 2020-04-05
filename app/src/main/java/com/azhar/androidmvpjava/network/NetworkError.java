package com.azhar.androidmvpjava.network;

import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.HttpException;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class NetworkError extends Throwable{

    public static final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again";
    public static final String NETWORK_ERROR_MESSAGE = "No Internet Connection";
    public static final String ERROR_MESSAGE_HEADER = "Error Message";
    private final Throwable error;

    public NetworkError(Throwable e){
        super(e);
        this.error = e;
    }

    public String getMessage(){
        return error.getMessage();
    }

    public boolean isAuthFailure(){
        return error instanceof HttpException &&
                ((HttpException)error).code() == HTTP_UNAUTHORIZED;
    }

    public boolean isResponseNull(){
        return error instanceof HttpException && ((HttpException)error).response() == null;
    }

    public String getAppErrorMessage(){
        if (this.error instanceof IOException) return NETWORK_ERROR_MESSAGE;
        if (!(this.error instanceof HttpException)) return DEFAULT_ERROR_MESSAGE;
        retrofit2.Response<?> response = ((HttpException) this.error).response();

        if (response != null){
            String status = getJsonStringFormatResponse(response);

            if (!TextUtils.isEmpty(status)) return status;

            Map<String, List<String>> headers = response.headers().toMultimap();
            if (headers.containsKey(ERROR_MESSAGE_HEADER))
                return headers.get(ERROR_MESSAGE_HEADER).get(0);
        }

        return DEFAULT_ERROR_MESSAGE;
    }

    protected String getJsonStringFormatResponse(final retrofit2.Response<?> response){
        try {
            String jsonString = response.errorBody().string();
            ResponseNetwork errorResponseNetwork = new Gson().fromJson(jsonString, ResponseNetwork.class);
            return errorResponseNetwork.status;

        }catch (Exception e){
            return null;
        }
    }

    public Throwable getError(){
        return error;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())return false;

        NetworkError mNeterror = (NetworkError) obj;

        return error != null ? error.equals(mNeterror.error) : mNeterror.error == null;
    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode(): 0;
    }
}
