package com.azhar.androidmvpjava.model.response;

import com.azhar.androidmvpjava.model.CityListData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CityListResponse {

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<CityListData> data = new ArrayList<CityListData>();

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public List<CityListData> getData(){
        return data;
    }

    public void setData(List<CityListData> data){
        this.data = data;
    }
}
