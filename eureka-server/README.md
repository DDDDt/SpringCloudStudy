# eureka-server
微服务注册和发现组件 eureka 的其中一个角色 eureka-server . 这个角色是用来注册服务和服务消费者  
主要通过注解 @EnableEurekaServer 来实现
### 碰到的坑
1. jar 包不能下载 , 一开始遇到 pom 文件的 jar 包一直抱 unknow 错 . 不能正常下载 (已解决)