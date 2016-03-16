package com.example.xiaohan_lh.qiongyouapp.model.impl;

import com.example.xiaohan_lh.qiongyouapp.api.RetrofitServerApi;
import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabDestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.model.TabModel;
import com.example.xiaohan_lh.qiongyouapp.utils.AppConnector;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Part;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public class TabModelImpl implements TabModel {
    private RetrofitServerApi retrofitServer;

    public TabModelImpl() {
        retrofitServer = new Retrofit.Builder()
                .baseUrl(AppConnector.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitServerApi.class);
    }

    @Override
    public void recommend(Callback<TabRecommendEntity> callback) {
        retrofitServer.getTabRecommend().enqueue(callback);
    }

    @Override
    public void destination(Callback<DestinationEntity> callback) {
        retrofitServer.getTabDestination().enqueue(callback);
    }

    @Override
    public void community(Callback<TabCommunityEntity> callback) {
        retrofitServer.getTabCommunity().enqueue(callback);
    }

    @Override
    public void hotListRecommend(Callback<HotListRecommendEntity> callback, String page) {
        retrofitServer.getHotListRecommend(page).enqueue(callback);
    }

    @Override
    public void countryDetail(Callback<CountryResponseEntity> callback, String countryid) {
        retrofitServer.getContryDetail(countryid).enqueue(callback);
    }
}
