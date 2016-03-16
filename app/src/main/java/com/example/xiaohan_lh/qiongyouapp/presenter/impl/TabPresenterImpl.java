package com.example.xiaohan_lh.qiongyouapp.presenter.impl;

import android.view.View;

import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabDestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.model.impl.TabModelImpl;
import com.example.xiaohan_lh.qiongyouapp.presenter.TabPresenter;
import com.example.xiaohan_lh.qiongyouapp.utils.AppConnector;
import com.example.xiaohan_lh.qiongyouapp.view.BaseView;
import com.example.xiaohan_lh.qiongyouapp.view.CommunityView;
import com.example.xiaohan_lh.qiongyouapp.view.CountryDetailView;
import com.example.xiaohan_lh.qiongyouapp.view.DestinationView;
import com.example.xiaohan_lh.qiongyouapp.view.HotListView;
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
        Callback<DestinationEntity> callback = new Callback<DestinationEntity>() {
            @Override
            public void onResponse(Call<DestinationEntity> call, Response<DestinationEntity> response) {
                DestinationEntity tabDestinationEntity = response.body();
                ((DestinationView) view).destinationSueccess(tabDestinationEntity);
            }

            @Override
            public void onFailure(Call<DestinationEntity> call, Throwable t) {
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

    @Override
    public void getHotListRecommend(String page) {
        Callback<HotListRecommendEntity> callback = new Callback<HotListRecommendEntity>() {
            @Override
            public void onResponse(Call<HotListRecommendEntity> call, Response<HotListRecommendEntity> response) {
                HotListRecommendEntity hotListRecommendEntity = response.body();
                ((HotListView) view).hotLiveViewSueccess(hotListRecommendEntity);
            }

            @Override
            public void onFailure(Call<HotListRecommendEntity> call, Throwable t) {
                view.fail(t);
            }
        };
        tabModel.hotListRecommend(callback,page);
    }

    @Override
    public void getCountryDetail(String countryid) {
        Callback<CountryResponseEntity> callback = new Callback<CountryResponseEntity>() {
            @Override
            public void onResponse(Call<CountryResponseEntity> call, Response<CountryResponseEntity> response) {
                CountryResponseEntity countryResponseEntity = response.body();
                ((CountryDetailView)view).countrydelSuccess(countryResponseEntity);
            }

            @Override
            public void onFailure(Call<CountryResponseEntity> call, Throwable t) {

            }
        };
        tabModel.countryDetail(callback,countryid);
    }
}
