# TT-ADMIN 轻量级开源框架

## 平台简介

TT-ADMIN是一个SpringBoot+React前后端分离项目，旨在为大家提供一个快速开发的模板，减少大部分重复性工作。预置后台系统的基本功能，抛弃不必要的功能，避免项目臃肿，可高度扩展，够轻量。  
前端项目地址
* React版本：[GitHub](https://github.com/tongsanghua/tt-admin-react)、[GitEE](https://gitee.com/tongsanghua/tt-admin-web)
* Vue版本（重构中，将采取和React版本一样的UI）：[GitHub](https://github.com/tongsanghua/tt-admin-vue)
* [演示地址](http://118.126.105.207:9090)

## 内置功能

1. 用户管理
2. 部门管理
3. 菜单管理
    - 支持配置菜单，路由，按钮
    - 与角色搭配实现权限控制
4. 角色管理
    - 菜单权限
    - 按钮权限
    - 接口权限
5. 操作日志
6. 版本管理
    - 控制前端打包版本
7. 代码生成器
    - 集成代码生成组件,[GitHub](https://github.com/tongsanghua/TTCode)、[GitEE](https://gitee.com/tongsanghua/TTCode)

## 技术选型

1. 核心框架：Spring Boot
2. 模板引擎：Thymeleaf
3. 持久层框架：MyBatis
4. 数据库连接池：Alibaba Druid 
5. 日志管理：logback 
