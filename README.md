---
title: javaee大作页
date: 2019-5-9 12:10
---

## 项目名称
# 二手书交易平台

### 项目目的
+ 作业，javaee课程项目期末作业，不写可能就要明年再来了
+ 熟悉一下后台的操作，以及数据库的设计

### 项目描述

+ 这个项目是自己选材的所以可能在需求方面没有那么清楚
+ 目的就是写一个二手书交易平台
+ 普通用户可以：买二手书，卖二手书，二手书网站的浏览，以及二手书的推荐
+ 管理员用户可以：对用户进行管理，对二手书进行管理，给用户充钱，查询某个用户的交易记录，看所有人的交易记录，还有增加用户
+ 书方面：用户购买后，卖家那边会显示买家基本个人信息。用户在浏览的同时，会有一个推荐的算法把书推荐给用户,
+ 买家来说，在购买完书的时候，会有一个地址选择，选择后，卖家就会收到相应的信息。
+ 钱的方向：目前想做的就是一个虚拟货币。

### 项目技术栈

+ 前后端分离
+ 前端vue，后台springboot ，http通信
+ 数据库采用mysql
+ 通信内容采用json

# 项目分析

## 数据库设计

### user表

|key|type|description|
|----|---|---|
|uerid|int|用户标识，子增长|
|password|string||
|username|string||
|phone|string||
|name|string||
|authority|string|admin or roleuser|

### money表

|key|type|description|
|---|---|---|
|usid|int|用户标识|
|money|int|用户账上的钱|

### address表

|key|type|description|
|---|---|---|
|usrid|int||
|address|string||

### book表

|key|type|description|
|---|---|---|
|bookid|int||
|solder|int|usrid|
|cost|int|价格为多少|
|normalcost|int|原价为多少|



### behavior表

|key|type|description|
|---|---|---|
