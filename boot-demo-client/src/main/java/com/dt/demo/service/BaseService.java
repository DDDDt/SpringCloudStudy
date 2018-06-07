package com.dt.demo.service;

import com.dt.demo.domain.BrandOpenHotelNum;

import java.util.List;
/**
 * @author dt 2018/6/6 14:58
 */
public interface BaseService {

    /**
     * 查询每个品牌对应的开业店数
     * @param siteId
     * @param brandCode
     * @return
     */
    public List<BrandOpenHotelNum> getBrandOpenHotelNum(String siteId, String... brandCode);

}
