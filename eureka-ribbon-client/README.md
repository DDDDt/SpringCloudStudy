# ribbon
ribbon 是一个开源的负载均衡组件
1. 通过结合 RestTemplate 和使用注解 @LoadBalanced 开启负载均衡
2. 结合 Feign 实现负载均衡
3. 结合 Hystrix 实现熔断机制
# Hystrix 使用方法
1. 再启动程序加上注解 @EnableHystrix 开启熔断机制
2. 在需要熔断的调用的方法前面加上 @HystrixCommand 并且需要著名调用失败的执行方法