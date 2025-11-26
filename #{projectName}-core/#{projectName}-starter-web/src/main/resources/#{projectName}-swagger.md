
#{ProjectName}Cloud是一款基于Spring Cloud Alibaba的微服务架构。旨在为大家提供技术框架的基础能力的封装，减少开发工作，让您只关注业务。

## 🎨 系统使用maven3.8.8进行构建，使用3.9+会有构建失败的问题

账号 | 密码| 操作权限
---|---|---
admin | 123456 | #{projectName}-system模块不能执行增删改请求

## 📌 版本演进
核心中间件 | 2.5.8及以下 | 3.0.8+
---|---|---
Spring Boot | 2.3.*.RELEASE | <img src="https://img.shields.io/badge/Spring%20Boot-2.6.7-blue" alt="SpringBoot"/>
Spring Cloud | Hoxton SR* | <img src="https://img.shields.io/badge/Spring%20Cloud-2021.0.2-blue" alt="SpringCloud"/>
Spring Cloud Alibaba | 2.2.*.RELEASE | <img src="https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2021.0.1.0-blue" alt="SpringCloudAlibaba"/>
Nacos | 1.4.*及以下 | <img src="https://img.shields.io/badge/Nacos-2.0.4-blue" alt="nacos"/>
Sentinel | 1.8.1 | <img src="https://img.shields.io/badge/Sentinel-1.8.3-blue" alt="sentinel"/>

## 🔧 功能特点
- 主体框架：采用最新的`Spring Cloud 2021.0.2`, `Spring Boot 2.7.14`, `Spring Cloud Alibaba 2021.0.1.0`版本进行系统设计；

- 统一注册：支持`Nacos`作为注册中心，实现多配置、分群组、分命名空间、多业务模块的注册和发现功能；

- 统一认证：统一`Oauth2`认证协议，采用jwt的方式，实现统一认证，并支持自定义grant_type实现手机号码登录，第三方登录集成JustAuth实现微信、支付宝等多种登录模式；

- 业务监控：利用`Spring Boot Admin`来监控各个独立Service的运行状态。

- 内部调用：集成了`Feign`和`Dubbo`两种模式支持内部调用，并且可以实现无缝切换，适合新老程序员，快速熟悉项目；

- 业务熔断：采用`Sentinel`实现业务熔断处理，避免服务之间出现雪崩;

- 身份注入：通过注解的方式，实现用户登录信息的快速注入；

- 在线文档：通过接入`Knife4j`，实现在线API文档的查看与调试;

- 代码生成：基于`Mybatis-plus-generator`自动生成代码，提升开发效率，生成模式不断优化中，暂不支持前端代码生成；

- 消息中心：集成消息中间件`RocketMQ`和`Kafka`，对业务进行异步处理;

- 业务分离：采用前后端分离的框架设计，前端采用`vue-element-admin`

- 链路追踪：自定义traceId的方式，实现简单的链路追踪功能

- 多租户功能：集成`Mybatis Plus`,实现SAAS多租户功能

## 🗿 文件结构
```lua
#{projectName}cloud -- 父项目,各模块分离，方便集成和微服务
│  ├─#{projectName}-core -- 核心通用模块，主模块
│  │  ├─#{projectName}-starter-common -- 封装通用模块
│  │  ├─#{projectName}-starter-cloud -- 封装微服务模块
│  │  ├─#{projectName}-starter-auth -- 封装token验证模块
│  │  ├─#{projectName}-starter-security -- 封装OAuth2基础模块
│  │  ├─#{projectName}-starter-web -- 封装WEB服务基础模块
│  │  ├─#{projectName}-starter-database -- 封装Mybatis及数据库基础模块
│  │  ├─#{projectName}-starter-dependencies -- 封装所有依赖模块，可作为父项目独立引用
│  │  ├─#{projectName}-starter-dubbo -- 封装dubbo基础模块
│  │  ├─#{projectName}-starter-feign -- 封装feign基础模块
│  │  ├─#{projectName}-starter-jetcache -- 封装JetCache阿里缓存基础模块
│  │  ├─#{projectName}-starter-rocketmq -- 封装RocketMQ基础模块
│  │  ├─#{projectName}-starter-gray -- 封装灰度发布基础模块
│  │  ├─#{projectName}-starter-elasticsearch -- 封装ElasticSearch模块
│  │  ├─#{projectName}-starter-oss -- 封装oss存储基础模块,支持阿里云、七牛云、minio等
│  │  ├─#{projectName}-starter-log -- 封装日志基础模块
│  │  ├─#{projectName}-starter-sharding -- 封装多数据库基础模块
│  │  ├─#{projectName}-starter-sms -- 封装短信基础模块
│  │  ├─#{projectName}-starter-mail -- 封装邮件模块
│  │  ├─#{projectName}-starter-kafka -- 封装kafka基础模块
│  │  ├─#{projectName}-starter-rule -- 封装黑名单基础模块
│  │  ├─#{projectName}-starter-idempotent -- 封装幂等基础模块
│  │  ├─#{projectName}-starter-lock -- 封装分布式锁基础模块
│  │  ├─#{projectName}-starter-encrypt -- 封装报文加密模块，支持AES和RSA
│  │  ├─#{projectName}-starter-mongodb -- 封装mongodb数据库模块
│  │  ├─#{projectName}-starter-strategy -- 封装策略模块
│  │  ├─#{projectName}-starter-job -- 封装定时任务基础模块
│  │  ├─#{projectName}-starter-validator -- 封装统一检验基础模块
│  │─#{projectName}-gateway -- 统一网关模块 [10001]
│  │─#{projectName}-uaa -- 统一认证中心模块 [20001]
│  │─#{projectName}-platform -- 平台模块项目，目前包含系统子模块
│  │  ├─#{projectName}-system-api -- 系统模块的通用模块，供其他模块引用
│  │  ├─#{projectName}-system -- 系统模块核心功能 [20002]
│  │  ├─#{projectName}-component-api -- 组件模块核心功能，供其他模块引用
│  │  ├─#{projectName}-component -- 组件模块核心功能 [20003]
│  │─#{projectName}-support -- 支持中心项目，目前包括代码生成、admin模块
│  │  ├─#{projectName}-code -- 封装代码生成逻辑 [30002]
│  │  ├─#{projectName}-admin -- 封装spring-boot-admin逻辑 [30001]
│  │  ├─#{projectName}-job -- xxl-jog定时任务模块
│  │  ├─#{projectName}-job-admin -- 定时任务管理平台模块
│  │─#{projectName}-mq -- 消息中心项目，支持kafka、RocketMQ等多种消息中间件
│  │  ├─#{projectName}-log-producer -- 日志消息生产者，集成kafka [40001]
│  │  ├─#{projectName}-message-consumer -- 消息服务消费者 [40002]
│  │  ├─#{projectName}-message-producer -- 消息服务生产者 [40003]
```
## 🎨 核心模块提交至中央仓库
如何引入依赖
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>#{groupId}</groupId>
            <artifactId>#{projectName}-starter-dependencies</artifactId>
            <version>#{version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
然后在 dependencies 中添加自己所需使用的依赖即可使用。

## 🔥 前端重大更新
前端采用`Vue 3.2.12`、`Vite 2.5.8`、 `Ant-Design-Vue 2.2.8`、`TypeScript` 的大型中后台解决方案。
### 👉 技术栈
- Vue 3.2.12
- Pinia 2.0.0-rc.8
- vue-i18n 9.1.7
- typescript 4.4.2
- ant-design-vue 2.2.6
- axios 0.21.3
- vue-router 4.3.8
- vite 2.5.8

