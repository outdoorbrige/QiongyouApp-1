package com.example.xiaohan_lh.qiongyouapp.bean;

import java.util.List;

/**
 * Created by xiaohan-lh on 16/3/14.
 */
public class TabDestinationEntity {

    /**
     * status : 1
     * info :
     * times : 0
     * data : [{"id":10,"cnname":"亚洲","enname":"Asia","hot_country":[{},{},{"id":14,"cnname":"日本","enname":"Japan","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411060609941.jpg","count":339,"label":"城市","flag":1},{"id":213,"cnname":"马来西亚","enname":"Malaysia","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062121492.jpg","count":143,"label":"城市","flag":1},{"id":233,"cnname":"韩国","enname":"South Korea","photo":"http://pic4.qyer.com/album/user/210/66/Q0hVRBwHaQ/index/420x630","count":38,"label":"城市","flag":1},{"id":62,"cnname":"新加坡","enname":"Singapore","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062502402.jpg","count":1500,"label":"旅行地","flag":2},{"id":219,"cnname":"柬埔寨","enname":"Cambodia","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062340933.jpg","count":17,"label":"城市","flag":1},{"id":216,"cnname":"越南","enname":"Vietnam","photo":"http://pic1.qyer.com/album/13c/9b/1929169/index/420x630","count":49,"label":"城市","flag":1}],"country":[{"id":401,"cnname":"阿富汗","enname":"Afghanistan","photo":"http://pic3.qyer.com/album/user/331/55/QkpURx8AaA/index/420x630","count":10,"label":"城市","flag":1},{"id":402,"cnname":"阿联酋","enname":"United Arab Emirates","photo":"http://pic3.qyer.com/album/user/212/98/Q0hXSxICYQ/index/420x630","count":10,"label":"城市","flag":1},{"id":403,"cnname":"阿曼","enname":"Oman","photo":"http://pic1.qyer.com/album/152/88/1140410/index/420x630","count":6,"label":"城市","flag":1},{"id":414,"cnname":"巴基斯坦","enname":"Pakistan","photo":"http://pic.qyer.com/album/user/213/12/Q0hWQxgOaQ/index/420x630","count":21,"label":"城市","flag":1},{"id":2041,"cnname":"巴勒斯坦","enname":"Palestine","photo":"http://pic4.qyer.com/album/user/885/22/SUFQQBgAaA/index/420x630","count":6,"label":"城市","flag":1},{"id":416,"cnname":"巴林","enname":"Bahrain","photo":"http://pic4.qyer.com/album/15d/ca/465127/index/420x630","count":2,"label":"城市","flag":1},{"id":433,"cnname":"不丹","enname":"Bhutan","photo":"http://pic.qyer.com/album/143/14/1878311/index/420x630","count":8,"label":"城市","flag":1},{"id":436,"cnname":"朝鲜","enname":"North Korea","photo":"http://pic1.qyer.com/album/170/1e/651757/index/420x630","count":6,"label":"城市","flag":1},{"id":438,"cnname":"东帝汶","enname":"East Timor","photo":"http://pic.qyer.com/album/114/2b/1990968/index/420x630","count":2,"label":"城市","flag":1},{"id":446,"cnname":"菲律宾","enname":"Philippines","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411063556532.jpg","count":44,"label":"城市","flag":1},{"id":461,"cnname":"哈萨克斯坦","enname":"Kazakhstan","photo":"http://pic.qyer.com/album/user/373/55/Qk5WRx8EaQ/index/420x630","count":20,"label":"城市","flag":1},{"id":468,"cnname":"吉尔吉斯斯坦","enname":"Kyrgyzstan","photo":"http://pic4.qyer.com/album/user/311/63/QkhURBkGYQ/index/420x630","count":6,"label":"城市","flag":1},{"id":476,"cnname":"卡塔尔","enname":"Qatar","photo":"http://pic.qyer.com/album/161/b6/473661/index/420x630","count":2,"label":"城市","flag":1},{"id":481,"cnname":"科威特","enname":"Kuwait","photo":"http://pic1.qyer.com/album/user/368/20/Qk9dQBoBYA/index/420x630","count":1,"label":"城市","flag":1},{"id":487,"cnname":"老挝","enname":"Laos","photo":"http://pic.qyer.com/album/155/2c/1125833/index/420x630","count":21,"label":"城市","flag":1},{"id":488,"cnname":"黎巴嫩","enname":"Lebanon","photo":"http://pic2.qyer.com/album/172/37/2033634/index/420x630","count":8,"label":"城市","flag":1},{"id":7789,"cnname":"马尔代夫","enname":"Maldives","photo":"http://pic1.qyer.com/album/103/23/1900298/index/420x630","count":101,"label":"旅行地","flag":2},{"id":507,"cnname":"蒙古","enname":"Mongolia","photo":"http://pic2.qyer.com/album/1dd/a8/433169/index/420x630","count":14,"label":"城市","flag":1},{"id":508,"cnname":"孟加拉国","enname":"Bangladesh","photo":"http://pic4.qyer.com/album/user/483/2/RUFWQhgGaQ/index/420x630","count":16,"label":"城市","flag":1},{"id":511,"cnname":"缅甸","enname":"Myanmar","photo":"http://pic2.qyer.com/album/user/339/43/QkpcRhkHYQ/index/420x630","count":48,"label":"城市","flag":1},{"id":220,"cnname":"尼泊尔","enname":"Nepal","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062418488.jpg","count":36,"label":"城市","flag":1},{"id":532,"cnname":"沙特阿拉伯","enname":"Saudi Arabia","photo":"http://pic4.qyer.com/album/16e/6f/1954685/index/420x630","count":6,"label":"城市","flag":1},{"id":537,"cnname":"斯里兰卡","enname":"Sri Lanka","photo":"http://pic4.qyer.com/album/1e8/5c/1118174/index/420x630","count":95,"label":"城市","flag":1},{"id":544,"cnname":"塔吉克斯坦","enname":"Tajikistan","photo":"http://pic3.qyer.com/album/user/331/51/QkpURxsEYw/index/420x630","count":6,"label":"城市","flag":1},{"id":552,"cnname":"土库曼斯坦","enname":"Turkmenistan","photo":"http://pic1.qyer.com/album/141/7b/1990979/index/420x630","count":5,"label":"城市","flag":1},{"id":558,"cnname":"文莱","enname":"Brunei","photo":"http://pic4.qyer.com/album/18b/bc/346518/index/420x630","count":4,"label":"城市","flag":1},{"id":562,"cnname":"乌兹别克斯坦","enname":"Uzbekistan","photo":"http://pic2.qyer.com/album/180/1a/1996724/index/420x630","count":12,"label":"城市","flag":1},{"id":564,"cnname":"叙利亚","enname":"Syria","photo":"http://pic.qyer.com/album/user/349/42/Qk1cRhgAaQ/index/420x630","count":11,"label":"城市","flag":1},{"id":567,"cnname":"也门","enname":"Yemen","photo":"http://pic2.qyer.com/album/user/482/28/RUFXQBIEYA/index/420x630","count":13,"label":"城市","flag":1},{"id":1035,"cnname":"伊拉克","enname":"Iraq","photo":"http://pic2.qyer.com/album/19b/1e/866558/index/420x630","count":12,"label":"城市","flag":1},{"id":568,"cnname":"伊朗","enname":"Iran","photo":"http://pic1.qyer.com/album/user/325/87/QktQSh0EaA/index/420x630","count":25,"label":"城市","flag":1},{"id":231,"cnname":"印度","enname":"India","photo":"http://pic3.qyer.com/album/user/214/24/Q0hRQB4AYQ/index/420x630","count":144,"label":"城市","flag":1},{"id":570,"cnname":"印度尼西亚","enname":"Indonesia","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411064846510.jpg","count":119,"label":"城市","flag":1},{"id":1425,"cnname":"英属印度洋领地","enname":"British Indian Ocean Territory","photo":"http://pic.qyer.com/album/user/508/39/REldQRMHZg/index/420x630","count":0,"label":"城市","flag":1},{"id":569,"cnname":"以色列","enname":"Israel","photo":"http://pic4.qyer.com/album/1d0/10/1849653/index/420x630","count":16,"label":"城市","flag":1},{"id":572,"cnname":"约旦","enname":"Jordan","photo":"http://pic.qyer.com/album/user/425/78/RUtQRRICZA/index/420x630","count":10,"label":"城市","flag":1}]}]
     * ra_referer :
     */

    private int status;
    private String info;
    private int times;
    private String ra_referer;
    /**
     * id : 10
     * cnname : 亚洲
     * enname : Asia
     * hot_country : [{},{},{"id":14,"cnname":"日本","enname":"Japan","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411060609941.jpg","count":339,"label":"城市","flag":1},{"id":213,"cnname":"马来西亚","enname":"Malaysia","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062121492.jpg","count":143,"label":"城市","flag":1},{"id":233,"cnname":"韩国","enname":"South Korea","photo":"http://pic4.qyer.com/album/user/210/66/Q0hVRBwHaQ/index/420x630","count":38,"label":"城市","flag":1},{"id":62,"cnname":"新加坡","enname":"Singapore","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062502402.jpg","count":1500,"label":"旅行地","flag":2},{"id":219,"cnname":"柬埔寨","enname":"Cambodia","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062340933.jpg","count":17,"label":"城市","flag":1},{"id":216,"cnname":"越南","enname":"Vietnam","photo":"http://pic1.qyer.com/album/13c/9b/1929169/index/420x630","count":49,"label":"城市","flag":1}]
     * country : [{"id":401,"cnname":"阿富汗","enname":"Afghanistan","photo":"http://pic3.qyer.com/album/user/331/55/QkpURx8AaA/index/420x630","count":10,"label":"城市","flag":1},{"id":402,"cnname":"阿联酋","enname":"United Arab Emirates","photo":"http://pic3.qyer.com/album/user/212/98/Q0hXSxICYQ/index/420x630","count":10,"label":"城市","flag":1},{"id":403,"cnname":"阿曼","enname":"Oman","photo":"http://pic1.qyer.com/album/152/88/1140410/index/420x630","count":6,"label":"城市","flag":1},{"id":414,"cnname":"巴基斯坦","enname":"Pakistan","photo":"http://pic.qyer.com/album/user/213/12/Q0hWQxgOaQ/index/420x630","count":21,"label":"城市","flag":1},{"id":2041,"cnname":"巴勒斯坦","enname":"Palestine","photo":"http://pic4.qyer.com/album/user/885/22/SUFQQBgAaA/index/420x630","count":6,"label":"城市","flag":1},{"id":416,"cnname":"巴林","enname":"Bahrain","photo":"http://pic4.qyer.com/album/15d/ca/465127/index/420x630","count":2,"label":"城市","flag":1},{"id":433,"cnname":"不丹","enname":"Bhutan","photo":"http://pic.qyer.com/album/143/14/1878311/index/420x630","count":8,"label":"城市","flag":1},{"id":436,"cnname":"朝鲜","enname":"North Korea","photo":"http://pic1.qyer.com/album/170/1e/651757/index/420x630","count":6,"label":"城市","flag":1},{"id":438,"cnname":"东帝汶","enname":"East Timor","photo":"http://pic.qyer.com/album/114/2b/1990968/index/420x630","count":2,"label":"城市","flag":1},{"id":446,"cnname":"菲律宾","enname":"Philippines","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411063556532.jpg","count":44,"label":"城市","flag":1},{"id":461,"cnname":"哈萨克斯坦","enname":"Kazakhstan","photo":"http://pic.qyer.com/album/user/373/55/Qk5WRx8EaQ/index/420x630","count":20,"label":"城市","flag":1},{"id":468,"cnname":"吉尔吉斯斯坦","enname":"Kyrgyzstan","photo":"http://pic4.qyer.com/album/user/311/63/QkhURBkGYQ/index/420x630","count":6,"label":"城市","flag":1},{"id":476,"cnname":"卡塔尔","enname":"Qatar","photo":"http://pic.qyer.com/album/161/b6/473661/index/420x630","count":2,"label":"城市","flag":1},{"id":481,"cnname":"科威特","enname":"Kuwait","photo":"http://pic1.qyer.com/album/user/368/20/Qk9dQBoBYA/index/420x630","count":1,"label":"城市","flag":1},{"id":487,"cnname":"老挝","enname":"Laos","photo":"http://pic.qyer.com/album/155/2c/1125833/index/420x630","count":21,"label":"城市","flag":1},{"id":488,"cnname":"黎巴嫩","enname":"Lebanon","photo":"http://pic2.qyer.com/album/172/37/2033634/index/420x630","count":8,"label":"城市","flag":1},{"id":7789,"cnname":"马尔代夫","enname":"Maldives","photo":"http://pic1.qyer.com/album/103/23/1900298/index/420x630","count":101,"label":"旅行地","flag":2},{"id":507,"cnname":"蒙古","enname":"Mongolia","photo":"http://pic2.qyer.com/album/1dd/a8/433169/index/420x630","count":14,"label":"城市","flag":1},{"id":508,"cnname":"孟加拉国","enname":"Bangladesh","photo":"http://pic4.qyer.com/album/user/483/2/RUFWQhgGaQ/index/420x630","count":16,"label":"城市","flag":1},{"id":511,"cnname":"缅甸","enname":"Myanmar","photo":"http://pic2.qyer.com/album/user/339/43/QkpcRhkHYQ/index/420x630","count":48,"label":"城市","flag":1},{"id":220,"cnname":"尼泊尔","enname":"Nepal","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411062418488.jpg","count":36,"label":"城市","flag":1},{"id":532,"cnname":"沙特阿拉伯","enname":"Saudi Arabia","photo":"http://pic4.qyer.com/album/16e/6f/1954685/index/420x630","count":6,"label":"城市","flag":1},{"id":537,"cnname":"斯里兰卡","enname":"Sri Lanka","photo":"http://pic4.qyer.com/album/1e8/5c/1118174/index/420x630","count":95,"label":"城市","flag":1},{"id":544,"cnname":"塔吉克斯坦","enname":"Tajikistan","photo":"http://pic3.qyer.com/album/user/331/51/QkpURxsEYw/index/420x630","count":6,"label":"城市","flag":1},{"id":552,"cnname":"土库曼斯坦","enname":"Turkmenistan","photo":"http://pic1.qyer.com/album/141/7b/1990979/index/420x630","count":5,"label":"城市","flag":1},{"id":558,"cnname":"文莱","enname":"Brunei","photo":"http://pic4.qyer.com/album/18b/bc/346518/index/420x630","count":4,"label":"城市","flag":1},{"id":562,"cnname":"乌兹别克斯坦","enname":"Uzbekistan","photo":"http://pic2.qyer.com/album/180/1a/1996724/index/420x630","count":12,"label":"城市","flag":1},{"id":564,"cnname":"叙利亚","enname":"Syria","photo":"http://pic.qyer.com/album/user/349/42/Qk1cRhgAaQ/index/420x630","count":11,"label":"城市","flag":1},{"id":567,"cnname":"也门","enname":"Yemen","photo":"http://pic2.qyer.com/album/user/482/28/RUFXQBIEYA/index/420x630","count":13,"label":"城市","flag":1},{"id":1035,"cnname":"伊拉克","enname":"Iraq","photo":"http://pic2.qyer.com/album/19b/1e/866558/index/420x630","count":12,"label":"城市","flag":1},{"id":568,"cnname":"伊朗","enname":"Iran","photo":"http://pic1.qyer.com/album/user/325/87/QktQSh0EaA/index/420x630","count":25,"label":"城市","flag":1},{"id":231,"cnname":"印度","enname":"India","photo":"http://pic3.qyer.com/album/user/214/24/Q0hRQB4AYQ/index/420x630","count":144,"label":"城市","flag":1},{"id":570,"cnname":"印度尼西亚","enname":"Indonesia","photo":"http://site.qyer.com/uploadfile/2014/0411/20140411064846510.jpg","count":119,"label":"城市","flag":1},{"id":1425,"cnname":"英属印度洋领地","enname":"British Indian Ocean Territory","photo":"http://pic.qyer.com/album/user/508/39/REldQRMHZg/index/420x630","count":0,"label":"城市","flag":1},{"id":569,"cnname":"以色列","enname":"Israel","photo":"http://pic4.qyer.com/album/1d0/10/1849653/index/420x630","count":16,"label":"城市","flag":1},{"id":572,"cnname":"约旦","enname":"Jordan","photo":"http://pic.qyer.com/album/user/425/78/RUtQRRICZA/index/420x630","count":10,"label":"城市","flag":1}]
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

    public void setRa_referer(String ra_referer) {
        this.ra_referer = ra_referer;
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

    public String getRa_referer() {
        return ra_referer;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public static class DataEntity {
        private int id;
        private String cnname;
        private String enname;
        /**
         * id : 401
         * cnname : 阿富汗
         * enname : Afghanistan
         * photo : http://pic3.qyer.com/album/user/331/55/QkpURx8AaA/index/420x630
         * count : 10
         * label : 城市
         * flag : 1
         */

        private List<CountryEntity> country;

        public void setId(int id) {
            this.id = id;
        }

        public void setCnname(String cnname) {
            this.cnname = cnname;
        }

        public void setEnname(String enname) {
            this.enname = enname;
        }

        public void setCountry(List<CountryEntity> country) {
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

        public List<CountryEntity> getCountry() {
            return country;
        }

        public static class CountryEntity {
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
        }
    }
}
