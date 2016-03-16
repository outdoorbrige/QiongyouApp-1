package com.example.xiaohan_lh.qiongyouapp.bean;

/**
 * Created by Administrator on 2016/3/16.
 */
public class CountryDiscountEntity {

    /**
     * id : 64180
     * title : 【清明/五一/端午假期】上海直飞台北+高雄6天往返含税机票(可选1/2晚住宿)
     * price : <em>1799</em>元起
     * priceoff : 5折
     * expire_date : 2016年06月29日结束
     * photo : http://pic.qyer.com/lastminute/library/2014/12/26/1419561800/300x200
     */

    private String id;
    private String title;
    private String price;
    private String priceoff;
    private String expire_date;
    private String photo;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPriceoff(String priceoff) {
        this.priceoff = priceoff;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceoff() {
        return priceoff;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public String getPhoto() {
        return photo;
    }
}
