package com.example.xiaohan_lh.qiongyouapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class DestinationEntity {

    /**
     * status : 1
     * info :
     * times : 0
     * data : []
     * ra_referer :
     */

    private int status;
    private String info;
    private int times;
    private String ra_referer;
    @SerializedName("data")
    private List<Continent> data;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setRa_referer(String ra_referer) {
        this.ra_referer = ra_referer;
    }

    public void setData(List<Continent> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public int getTimes() {
        return times;
    }

    public String getRa_referer() {
        return ra_referer;
    }

    public List<Continent> getData() {
        return data;
    }
}
