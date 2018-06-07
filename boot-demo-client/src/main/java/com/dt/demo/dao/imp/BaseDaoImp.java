package com.dt.demo.dao.imp;


import com.dt.demo.dao.BaseDao;
import com.dt.demo.dataInter.BaseIter;
import com.dt.demo.domain.BrandOpenHotelNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author dt 2018/6/6 14:56
 */
@Repository
public class BaseDaoImp implements BaseDao {

    @Autowired
    private BaseIter baseIter;

    /**
     * 查找每个品牌每个渠道的开业店数
     * @param map
     * @return
     */
    public List<BrandOpenHotelNum> getBrandOpenHotelNum(Map<String,Object> map){
        return baseIter.selBrandOpenHotelNum(map);
    }

}
