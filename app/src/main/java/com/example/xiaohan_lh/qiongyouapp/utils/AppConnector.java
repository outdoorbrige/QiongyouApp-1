package com.example.xiaohan_lh.qiongyouapp.utils;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public class AppConnector {
    public static final String BASE_URL = "http://open.qyer.com/";
    public static class Tab {
        public static final String TAB_RECOMMEND = "/qyer/recommands/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=34.693737&lon=135.502167&channel=360m";
        public static final String TAB_DESTINATION = "/qyer/footprint/continent_list?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=34.693737&lon=135.502167";
        public static final String TAB_COMMUNITY = "/qyer/bbs/entry?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=31.378791&lon=121.491697";
    }
    public static class Recommend{
        public static final String LIST_RECOMMEND = "/qyer/recommands/trip?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=31.378791&lon=121.491697&type=index&count=10";
        public static final String NEXTSTATION_RECOMMEND = "/qyer/special/topic/special_list?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=7634302&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=31.378815&lon=121.491693&oauth_token=a7f7fbe9980ed6fdaa2a20db48d53ceb&count=10";
        public static final String MILEAGE_RECOMMEDN = "http://appview.qyer.com/mileage/sign/sign?track_deviceid=863784027041925&client_id=qyer_android&track_app_version=6.8.5";
        public static final String LIST_DISCOUNT_RECOMMEND = "/lastminute/get_all_categorys";
    }

    public static class Detail{
        //国家详情
        public static final String COUNTRY_DETAIL="qyer/footprint/country_detail?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=31.378791&lon=121.491697";
        //城市详情
        public static final String CITY_DETAIL = "qyer/footprint/city_detail?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_user_id=7634302&track_deviceid=863784027041925&track_app_version=6.8.5&track_app_channel=360m&track_device_info=NX507J&track_os=Android4.4.2&app_installtime=1457922803165&lat=31.383219&lon=121.491148";
    }


}
