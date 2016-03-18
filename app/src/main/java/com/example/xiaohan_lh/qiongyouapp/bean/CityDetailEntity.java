package com.example.xiaohan_lh.qiongyouapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
public class CityDetailEntity {


    /**
     * id : 50
     * country_id : 11
     * planto : 0
     * beento : 0
     * overview_url : http://appview.qyer.com/place/hong-kong/profile
     * selecthotel_url : http://appview.qyer.com/index.php?action=hotelDetail&spm=index&aid=352438&cityid=50
     * photos : []
     * has_guide : true
     * has_plan : true
     * country_cnname : 中国
     * country_enname : China
     * cnname : 香港
     * enname : Hong Kong
     * has_trip : true
     * entryCont : 香港，是张爱玲笔下那座华丽摩登的悲情之城，是王家卫电影里那点纸醉金迷的风情万种，是艾敬“我的1997”那一曲中的花花世界，是TVB镜头前不断流转的市井气息。150多年的英国殖民地风尚和源远流长的东方传统文化的激烈碰撞造就了这个“亚洲国际都会”的传奇。而今，这座“钢筋水泥的森林”依旧矗立在中国的最东南
     * hot_mguide : []
     * new_discount : []
     * local_discount : []
     */

    private int id;
    private int country_id;
    private int planto;
    private int beento;
    private String overview_url;
    private String selecthotel_url;
    private boolean has_guide;
    private boolean has_plan;
    private String country_cnname;
    private String country_enname;
    private String cnname;
    private String enname;
    private boolean has_trip;
    private String entryCont;
    private List<String> photos;
    private List<CountryMugideEntity> hot_mguide;
    private List<CountryDiscountEntity> new_discount;
    private List<CountryDiscountEntity> local_discount;

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public void setPlanto(int planto) {
        this.planto = planto;
    }

    public void setBeento(int beento) {
        this.beento = beento;
    }

    public void setOverview_url(String overview_url) {
        this.overview_url = overview_url;
    }

    public void setSelecthotel_url(String selecthotel_url) {
        this.selecthotel_url = selecthotel_url;
    }

    public void setHas_guide(boolean has_guide) {
        this.has_guide = has_guide;
    }

    public void setHas_plan(boolean has_plan) {
        this.has_plan = has_plan;
    }

    public void setCountry_cnname(String country_cnname) {
        this.country_cnname = country_cnname;
    }

    public void setCountry_enname(String country_enname) {
        this.country_enname = country_enname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public void setHas_trip(boolean has_trip) {
        this.has_trip = has_trip;
    }

    public void setEntryCont(String entryCont) {
        this.entryCont = entryCont;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public void setHot_mguide(List<CountryMugideEntity> hot_mguide) {
        this.hot_mguide = hot_mguide;
    }

    public void setNew_discount(List<CountryDiscountEntity> new_discount) {
        this.new_discount = new_discount;
    }

    public void setLocal_discount(List<CountryDiscountEntity> local_discount) {
        this.local_discount = local_discount;
    }

    public int getId() {
        return id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public int getPlanto() {
        return planto;
    }

    public int getBeento() {
        return beento;
    }

    public String getOverview_url() {
        return overview_url;
    }

    public String getSelecthotel_url() {
        return selecthotel_url;
    }

    public boolean isHas_guide() {
        return has_guide;
    }

    public boolean isHas_plan() {
        return has_plan;
    }

    public String getCountry_cnname() {
        return country_cnname;
    }

    public String getCountry_enname() {
        return country_enname;
    }

    public String getCnname() {
        return cnname;
    }

    public String getEnname() {
        return enname;
    }

    public boolean isHas_trip() {
        return has_trip;
    }

    public String getEntryCont() {
        return entryCont;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public List<CountryMugideEntity> getHot_mguide() {
        return hot_mguide;
    }

    public List<CountryDiscountEntity> getNew_discount() {
        return new_discount;
    }

    public List<CountryDiscountEntity> getLocal_discount() {
        return local_discount;
    }
}
