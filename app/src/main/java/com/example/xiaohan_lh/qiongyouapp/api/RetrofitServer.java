package com.example.xiaohan_lh.qiongyouapp.api;

import com.example.xiaohan_lh.qiongyouapp.bean.TabRecommend;
import com.example.xiaohan_lh.qiongyouapp.utils.AppConnector;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public interface RetrofitServer {
    @GET(AppConnector.Tab.TAB_RECOMMEND)
    Call<TabRecommend> getTabRecommend();
}
