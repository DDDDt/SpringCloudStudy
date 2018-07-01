# Feign
## 声明式调用 Feign
1. 封装的一层 httpclient 提供声明式调用接口的方法
2. 在 Feign 的起步依赖中已经引入了 Hystrix 的依赖，所以在 Feign 使用 Hystrix 不需要引用任何依赖

## 使用说明
1. 在配置文件中开启 Hystrix 功能
2. 在 Feign 接口中指定 fallback 错误返回的方法