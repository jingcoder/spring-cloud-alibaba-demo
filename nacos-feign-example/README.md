#### 模块简介

本模块是主要用于学习 nacos+feign+hystrix的demo,以下是三个模块的功能介绍:

- nacos-feign-consumer: feign客户端使用,hystrix降级,hystrix的监控面板功能(页面访问地址:http://localhost:8111/hystrix/monitor,页面上输入的监控地址为:http://localhost:8111/hystrix.stream )
- nacos-feign-provider: 一个简单的服务提供者,注册到nacos去;
 
#### 笔记

1. hystrix默认是关闭的,需要加上此配置 feign.hystrix.enabled=true
2. Hystrix Dashbord 在SpringBoot 2.0版本还需要配置endpoint,配置类为`HystrixDashboardConfig`;
3. 生产环境下,还需要使用`Turbine`进行收集汇总集群的多个节点的监控信息.


