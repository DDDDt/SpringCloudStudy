package com.dt.demo.dao;



import com.dt.demo.domain.BrandOpenHotelNum;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dt 2018/6/6 14:56
 */
@Repository
public interface BaseDao {

    /**
     * 查找每个品牌每个渠道的开业店数
     * @param map
     * @return
     */
    public List<BrandOpenHotelNum> getBrandOpenHotelNum(Map<String, Object> map);

}
