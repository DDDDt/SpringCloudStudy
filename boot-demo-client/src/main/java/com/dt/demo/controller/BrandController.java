package com.dt.demo.controller;

import com.dt.demo.domain.BrandOpenHotelNum;
import com.dt.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dt 2018/6/7 12:08
 */
@RestController("/brand")
public class BrandController {

    @Autowired
    private BaseService baseServiceImp;

    @GetMapping("/getBrandOpen")
    public List<BrandOpenHotelNum> getBrandOpen(@PathVariable("siteId") String siteId, @PathVariable String brandCode){

        return baseServiceImp.getBrandOpenHotelNum(siteId,brandCode.split(","));

    }

}
