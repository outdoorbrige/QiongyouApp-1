package com.example.xiaohan_lh.qiongyouapp.model;

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
    public void destination(Callback<TabDestinationEntity> callback);
    public void community(Callback<TabCommunityEntity> callback);
}
