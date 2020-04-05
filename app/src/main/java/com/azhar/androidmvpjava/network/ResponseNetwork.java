package com.azhar.androidmvpjava.network;

import com.google.gson.annotations.SerializedName;

public class ResponseNetwork {

    @SerializedName("status")
    public String status;

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public ResponseNetwork(){

    }

    public ResponseNetwork(String status){
        this.status = status;
    }

}
