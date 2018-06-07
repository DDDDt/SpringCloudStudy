package com.dt.demo.dataInter;


import com.dt.demo.domain.BrandOpenHotelNum;

import java.util.List;
import java.util.Map;

/**
 * @author dt 2018/6/6 14:49
 */
public interface BaseIter {

    /**
     * 查找每个品牌每个酒店的开业店数
     * @param map
     * @return
     */
    public List<BrandOpenHotelNum> selBrandOpenHotelNum(Map<String, Object> map);

}
