package com.example.xiaohan_lh.qiongyouapp.bean;

/**
 * Created by Administrator on 2016/3/16.
 */
public class CountryCityEntity {

    /**
     * id : 50
     * cnname : 香港
     * enname : Hong Kong
     * photo : http://pic3.qyer.com/album/user/370/89/Qk5VShMOaA/index/339x226
     */

    private String id;
    private String cnname;
    private String enname;
    private String photo;

    public void setId(String id) {
        this.id = id;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }
}
