package com.example.xiaohan_lh.qiongyouapp.presenter.impl;

import android.view.View;

import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabDestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.model.impl.TabModelImpl;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.view.BaseView;
import com.example.xiaohan_lh.qiongyouapp.view.CommunityView;
import com.example.xiaohan_lh.qiongyouapp.view.DestinationView;
import com.example.xiaohan_lh.qiongyouapp.view.RecommendView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public class TabPresenterImpl implements TabPresenter {
    private BaseView view;
    private TabModelImpl tabModel;

    public TabPresenterImpl(BaseView view) {
        tabModel = new TabModelImpl();
        this.view = view;
    }

    @Override
    public void getRecommend() {
        Callback<TabRecommendEntity> callback = new Callback<TabRecommendEntity>() {
            @Override
            public void onResponse(Call<TabRecommendEntity> call, Response<TabRecommendEntity> response) {
                TabRecommendEntity tabRecommendEntity = response.body();
                ((RecommendView) view).RecommenndSueccess(tabRecommendEntity);
            }

            @Override
            public void onFailure(Call<TabRecommendEntity> call, Throwable t) {
                view.fail(t);
            }
        };
        tabModel.recommend(callback);
    }

    @Override
    public void getDestination() {
        Callback<TabDestinationEntity> callback = new Callback<TabDestinationEntity>() {
            @Override
            public void onResponse(Call<TabDestinationEntity> call, Response<TabDestinationEntity> response) {
                TabDestinationEntity tabDestinationEntity = response.body();
                ((DestinationView) view).destinationSueccess(tabDestinationEntity);
            }

            @Override
            public void onFailure(Call<TabDestinationEntity> call, Throwable t) {
                view.fail(t);
            }
        };
        tabModel.destination(callback);
    }

    @Override
    public void getCommunity() {
        Callback<TabCommunityEntity> callback = new Callback<TabCommunityEntity>() {
            @Override
            public void onResponse(Call<TabCommunityEntity> call, Response<TabCommunityEntity> response) {
                TabCommunityEntity tabCommunityEntity = response.body();
                ((CommunityView) view).communitySueccess(tabCommunityEntity);
            }

            @Override
            public void onFailure(Call<TabCommunityEntity> call, Throwable t) {
                view.fail(t);
            }
        };
        tabModel.community(callback);
    }
}
