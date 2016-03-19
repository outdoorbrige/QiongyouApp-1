package com.example.xiaohan_lh.qiongyouapp.presenter.impl;

import android.view.View;
import android.widget.Toast;

import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DiscountRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.NextStationEntity;
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
import com.example.xiaohan_lh.qiongyouapp.view.DiscountView;
import com.example.xiaohan_lh.qiongyouapp.view.HotListView;
import com.example.xiaohan_lh.qiongyouapp.view.NextStationView;
import com.example.xiaohan_lh.qiongyouapp.view.RecommendView;

import java.util.Map;

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

    @Override
    public void getNextstation(String page) {
        Callback<NextStationEntity> callback = new Callback<NextStationEntity>() {
            @Override
            public void onResponse(Call<NextStationEntity> call, Response<NextStationEntity> response) {
                NextStationEntity nextStationEntity = response.body();
                ((NextStationView) view).NextStationSueccess(nextStationEntity);
            }

            @Override
            public void onFailure(Call<NextStationEntity> call, Throwable t) {
                view.fail(t);
            }
        };
        tabModel.nextStation(callback,page);
    }

    @Override
    public void getDiscountRecommend(Map<String, String> map) {
        Callback<DiscountRecommendEntity> callback = new Callback<DiscountRecommendEntity>() {
            @Override
            public void onResponse(Call<DiscountRecommendEntity> call, Response<DiscountRecommendEntity> response) {
                DiscountRecommendEntity discountRecommendEntity = response.body();
                ((DiscountView) view).discountSueccess(discountRecommendEntity);
            }

            @Override
            public void onFailure(Call<DiscountRecommendEntity> call, Throwable t) {
                view.fail(t);
            }
        };
        tabModel.discount(callback,map);
    }
}
