package com.azhar.androidmvpjava.model.response;

import com.azhar.androidmvpjava.model.MhsListData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MhsListResponse {

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<MhsListData> data = new ArrayList<MhsListData>();

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

    public List<MhsListData> getData(){
        return data;
    }

    public void setData(List<MhsListData> data){
        this.data = data;
    }
}
