package com.example.xiaohan_lh.qiongyouapp.api;

import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabDestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.utils.AppConnector;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public interface RetrofitServerApi {
    @GET(AppConnector.Tab.TAB_RECOMMEND)
    Call<TabRecommendEntity> getTabRecommend();
    @GET(AppConnector.Tab.TAB_DESTINATION)
    Call<TabDestinationEntity> getTabDestination();
    @GET(AppConnector.Tab.TAB_COMMUNITY)
    Call<TabCommunityEntity> getTabCommunity();
}
