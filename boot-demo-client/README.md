# spring boot demo
spring boot 结合 mybatis 和 redis 项目 demo  
### 注意
1. 启动该项目需要先启动 eureka-server 注册中心
2. 如果不想启动 eureka-server 项目 ，可以注销掉 com.dt.demo.BootDemoApplication 的 @EnableEurekaClient 注解
3. 如果没有注销 @EnableEurekaClient 并且启动了 eureka-server 项目， 可以通过 `http://localhost:8080/` 查看注册的消息及组件

### sql
```$xslt
CREATE TABLE `MS_EST_WH_BRAND_OPEN_HOTEL_NUM` (
  `ID` int(100) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `BRAND_CODE` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '品牌code',
  `SITE_ID` int(11) NOT NULL COMMENT '渠道ID',
  `NUM` int(11) DEFAULT '0' COMMENT '数量',
  `UPDATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CREATE_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BRAND_CODE` (`BRAND_CODE`,`SITE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `bigdata`.`MS_EST_WH_BRAND_OPEN_HOTEL_NUM` (`ID`, `BRAND_CODE`, `SITE_ID`, `NUM`, `UPDATE_TIME`, `CREATE_TIME`) VALUES ('1', '1', '2', '1', '2018-05-10 15:34:00', '2018-05-10 15:34:00');
INSERT INTO `bigdata`.`MS_EST_WH_BRAND_OPEN_HOTEL_NUM` (`ID`, `BRAND_CODE`, `SITE_ID`, `NUM`, `UPDATE_TIME`, `CREATE_TIME`) VALUES ('2', '2', '2', '2', '2018-05-10 15:34:00', '2018-05-10 15:34:00');

``` 
### 调用地址
```
http://localhost:8094/getBrandOpen?siteId=2&brandCode=1,2
```