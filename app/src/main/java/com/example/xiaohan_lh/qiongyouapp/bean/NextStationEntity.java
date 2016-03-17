package com.example.xiaohan_lh.qiongyouapp.bean;

import java.util.List;

/**
 * Created by xiaohan-lh on 16/3/17.
 */
public class NextStationEntity {

    /**
     * status : 1
     * info : OK
     * times : 0
     * data : [{"title":"带你赏遍世界的樱花海 樱华秘境","url":"http://appview.qyer.com/op/zt/20160311.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/03/11/14576608118143/600x400"},{"title":"东京特色主题餐厅大盘点","url":"http://appview.qyer.com/op/zt/20160201.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/02/01/14542936169023/600x400"},{"title":"京都特色店一览！","url":"http://appview.qyer.com/op/zt/20160224.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/02/24/14562976249731/600x400"},{"title":"斯里兰卡，你得这么玩！","url":"http://appview.qyer.com/op/zt/20151102.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2015/11/02/14464306939034/600x400"},{"title":"舌尖上的年夜饭！","url":"http://appview.qyer.com/op/zt/20160205.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/02/04/14545749719310/600x400"},{"title":"春节海岛趴开始啦！","url":"http://appview.qyer.com/op/zt/20160204.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/02/03/14544902023472/600x400"},{"title":"2015境外人气餐厅榜单","url":"http://appview.qyer.com/op/zt/20160203.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/02/02/14543981871040/600x400"},{"title":"去东京 赏樱花","url":"http://appview.qyer.com/op/zt/20160127.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2016/01/27/14538604566432/600x400"},{"title":"窗外处处是美景！新西兰自驾不可错过的景点","url":"http://appview.qyer.com/op/zt/20151023.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2015/10/26/14458413991396/600x400"},{"title":"这个秋天，错过等一年\u2014\u2014盘点全球最佳秋景","url":"http://appview.qyer.com/op/zt/20151015.html","photo":"http://pic.qyer.com/public/mobileapp/appzt/2015/10/16/14449866784588/600x400"}]
     */

    private int status;
    private String info;
    private int times;
    /**
     * title : 带你赏遍世界的樱花海 樱华秘境
     * url : http://appview.qyer.com/op/zt/20160311.html
     * photo : http://pic.qyer.com/public/mobileapp/appzt/2016/03/11/14576608118143/600x400
     */

    private List<DataEntity> data;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getInfo() {
        return info;
    }

    public int getTimes() {
        return times;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private String title;
        private String url;
        private String photo;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public String getPhoto() {
            return photo;
        }
    }
}
