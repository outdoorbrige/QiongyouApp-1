package com.example.xiaohan_lh.qiongyouapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class Continent {

    /**
     * id : 10
     * cnname : 亚洲
     * enname : Asia
     * hot_country : []
     * country : []
     */

    private int id;
    private String cnname;
    private String enname;

    @SerializedName("hot_country")
    private List<Country> hot_country;
    @SerializedName("country")
    private List<Country> country;

    public void setId(int id) {
        this.id = id;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public void setHot_country(List<Country> hot_country) {
        this.hot_country = hot_country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getCnname() {
        return cnname;
    }

    public String getEnname() {
        return enname;
    }

    public List<Country> getHot_country() {
        return hot_country;
    }

    public List<Country> getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", cnname='" + cnname + '\'' +
                ", enname='" + enname + '\'' +
                ", hot_country=" + hot_country +
                ", country=" + country +
                '}';
    }
}
