package com.dt.demo.enumerate;

/**
 * @author dt 2018/6/7 12:15
 */
public enum RedisKeyEnum {
    /*记录每个品牌每个渠道的开业店数*/
    YXTBrandOpenHotelNumCache("MS_EST_WH_YXT_BRAND_OPEN_HOTEL_CACHE:");
    private String baseKey;

    RedisKeyEnum(String baseKey) {
        this.baseKey = baseKey;
    }

    public String getBaseKey() {
        return baseKey;
    }

    public void setBaseKey(String baseKey) {
        this.baseKey = baseKey;
    }
}
