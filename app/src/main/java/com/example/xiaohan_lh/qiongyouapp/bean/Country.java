package com.example.xiaohan_lh.qiongyouapp.bean;

/**
 * Created by Administrator on 2016/3/14.
 */
public class Country {

    /**
     * id : 186
     * cnname : 法国
     * enname : France
     * photo : http://pic3.qyer.com/album/1cf/57/1041072/index/420x630
     * count : 421
     * label : 城市
     * flag : 1
     */

    private int id;
    private String cnname;
    private String enname;
    private String photo;
    private int count;
    private String label;
    private int flag;

    public void setId(int id) {
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

    public void setCount(int count) {
        this.count = count;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setFlag(int flag) {
        this.flag = flag;
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

    public String getPhoto() {
        return photo;
    }

    public int getCount() {
        return count;
    }

    public String getLabel() {
        return label;
    }

    public int getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", cnname='" + cnname + '\'' +
                ", enname='" + enname + '\'' +
                ", photo='" + photo + '\'' +
                ", count=" + count +
                ", label='" + label + '\'' +
                ", flag=" + flag +
                '}';
    }
}
