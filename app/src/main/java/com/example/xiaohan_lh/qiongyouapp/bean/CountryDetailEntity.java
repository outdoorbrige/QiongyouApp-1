package com.example.xiaohan_lh.qiongyouapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/16.
 */
public class CountryDetailEntity {

    /**
     * id : 11
     * cnname : 中国
     * enname : China
     * planto : 0
     * beento : 0
     * photos : []
     * overview_url : http://appview.qyer.com/place/china/ctyprofile?spm=app
     * entryCont : 普通话在大部分地区适用，部分地区通用维吾尔语，蒙古语，藏语，壮语，傣语，哈萨克语等
     * has_guide : true
     * has_plan : true
     * has_trip : true
     * hot_city : []
     * hot_mguide : []
     * new_discount : []
     */

    private String id;
    private String cnname;
    private String enname;
    private int planto;
    private int beento;
    private String overview_url;
    private String entryCont;
    private boolean has_guide;
    private boolean has_plan;
    private boolean has_trip;
    private List<String> photos;
    private List<CountryCityEntity> hot_city;
    private List<CountryMugideEntity> hot_mguide;
    private List<CountryDiscountEntity> new_discount;

    public void setId(String id) {
        this.id = id;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
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

    public void setEntryCont(String entryCont) {
        this.entryCont = entryCont;
    }

    public void setHas_guide(boolean has_guide) {
        this.has_guide = has_guide;
    }

    public void setHas_plan(boolean has_plan) {
        this.has_plan = has_plan;
    }

    public void setHas_trip(boolean has_trip) {
        this.has_trip = has_trip;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public void setHot_city(List<CountryCityEntity> hot_city) {
        this.hot_city = hot_city;
    }

    public void setHot_mguide(List<CountryMugideEntity> hot_mguide) {
        this.hot_mguide = hot_mguide;
    }

    public void setNew_discount(List<CountryDiscountEntity> new_discount) {
        this.new_discount = new_discount;
    }

    public String getId() {
        return id;
    }

    public String getCnname() {
        return cnname;
    }

    public String getEnname() {
        return enname;
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

    public String getEntryCont() {
        return entryCont;
    }

    public boolean isHas_guide() {
        return has_guide;
    }

    public boolean isHas_plan() {
        return has_plan;
    }

    public boolean isHas_trip() {
        return has_trip;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public List<CountryCityEntity> getHot_city() {
        return hot_city;
    }

    public List<CountryMugideEntity> getHot_mguide() {
        return hot_mguide;
    }

    public List<CountryDiscountEntity> getNew_discount() {
        return new_discount;
    }
}
