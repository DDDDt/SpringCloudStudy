package com.dt.demo.service.imp;


import com.alibaba.fastjson.JSONObject;
import com.dt.demo.dao.BaseDao;
import com.dt.demo.domain.BrandOpenHotelNum;
import com.dt.demo.enumerate.RedisKeyEnum;
import com.dt.demo.service.BaseService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * @author dt 2018/6/6 14:59
 */
@Service
public class BaseServiceImp implements BaseService {

    @Autowired
    private BaseDao baseDaoImp;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 查询每个品牌对应的开业店数
     * @param siteId
     * @param brandCode
     * @return
     */
    public List<BrandOpenHotelNum> getBrandOpenHotelNum(String siteId, String... brandCode){

        BoundHashOperations<String, String, String> stringBoundRedisTemplate = redisTemplate.<String, String>boundHashOps(String.format("%s%s", RedisKeyEnum.YXTBrandOpenHotelNumCache.getBaseKey(), siteId));

        List<String> brandCodeList = new ArrayList<>(Arrays.asList(brandCode));
        List<BrandOpenHotelNum> brandOpenHotelNumList = new ArrayList<>();
        if(brandCode == null || brandCode.length == 0){
            Optional<Map<String, String>> openHotelNameOptional = Optional.ofNullable(stringBoundRedisTemplate.entries());
            openHotelNameOptional.ifPresent(openHotel -> {
                openHotel.forEach((k,v) -> {
                    if(!StringUtils.isBlank(v)){
                        BrandOpenHotelNum brandOpenHotelNum = JSONObject.parseObject(v,BrandOpenHotelNum.class);
                        brandOpenHotelNumList.add(brandOpenHotelNum);
                    }
                });
            });
        }else{
            Optional<List<String>> openHotelNameOptional = Optional.ofNullable(stringBoundRedisTemplate.multiGet(brandCodeList));
            openHotelNameOptional.ifPresent(openHotel -> {
                openHotel.forEach(openHotelStr -> {
                    if(!StringUtils.isBlank(openHotelStr)){
                        BrandOpenHotelNum brandOpenHotelNum = JSONObject.parseObject(openHotelStr,BrandOpenHotelNum.class);
                        brandCodeList.remove(brandOpenHotelNum.getBrandCode());
                        brandOpenHotelNumList.add(brandOpenHotelNum);
                    }
                });
            });
        }
        if(CollectionUtils.isNotEmpty(brandCodeList)){
            Map<String,Object> parMap = new HashMap<>();
            parMap.put("siteId",siteId);
            parMap.put("brandCodeList",brandCodeList);
            Optional<List<BrandOpenHotelNum>> brandOpenHotelNumOptional = Optional.ofNullable(baseDaoImp.getBrandOpenHotelNum(parMap));
            brandOpenHotelNumOptional.ifPresent(openHotel -> {
                Map<String, String> openHotelMap = openHotel.stream().collect(Collectors.toMap(BrandOpenHotelNum::getBrandCode, x -> JSONObject.toJSONString(x), (x, y) -> x));
                if(!openHotelMap.isEmpty()){
                    stringBoundRedisTemplate.putAll(openHotelMap);
                    stringBoundRedisTemplate.expire(10,TimeUnit.NANOSECONDS);

                }
                brandOpenHotelNumList.addAll(openHotel);
            });
        }

        return brandOpenHotelNumList;

    }

}
