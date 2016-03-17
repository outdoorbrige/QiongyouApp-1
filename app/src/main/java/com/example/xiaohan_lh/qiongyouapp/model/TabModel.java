package com.example.xiaohan_lh.qiongyouapp.model;

import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.NextStationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabDestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public interface TabModel {
    public void recommend(Callback<TabRecommendEntity> callback);
    public void destination(Callback<DestinationEntity> callback);
    public void community(Callback<TabCommunityEntity> callback);
    public void hotListRecommend(Callback<HotListRecommendEntity> callback,String page);
    public void countryDetail(Callback<CountryResponseEntity> callback,String countryid);
    public void nextStation(Callback<NextStationEntity> callback,String page);
}
