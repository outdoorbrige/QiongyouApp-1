package com.example.xiaohan_lh.qiongyouapp.api;

import com.example.xiaohan_lh.qiongyouapp.bean.CityDetailResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.CountryResponseEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DestinationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.DiscountRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.HotListRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.NextStationEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabCommunityEntity;
import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommendEntity;
import com.example.xiaohan_lh.qiongyouapp.utils.AppConnector;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public interface RetrofitServerApi {
    @GET(AppConnector.Tab.TAB_RECOMMEND)
    Call<TabRecommendEntity> getTabRecommend();
    @GET(AppConnector.Tab.TAB_DESTINATION)
    Call<DestinationEntity> getTabDestination();
    @GET(AppConnector.Tab.TAB_COMMUNITY)
    Call<TabCommunityEntity> getTabCommunity();
    @GET(AppConnector.Recommend.LIST_RECOMMEND)
    Call<HotListRecommendEntity> getHotListRecommend(@Query("page") String page);
    @GET(AppConnector.Detail.COUNTRY_DETAIL)
    Call<CountryResponseEntity> getContryDetail(@Query("country_id") String country_id);
    @GET(AppConnector.Detail.CITY_DETAIL)
    Call<CityDetailResponseEntity> getCityDetail(@Query("city_id") String city_id);
    @GET(AppConnector.Recommend.NEXTSTATION_RECOMMEND)
    Call<NextStationEntity> getNextStation(@Query("page") String page);
    @POST(AppConnector.Recommend.LIST_DISCOUNT_RECOMMEND)
    Call<DiscountRecommendEntity> getDiscountRecommend(@QueryMap Map<String,String> map);

}
