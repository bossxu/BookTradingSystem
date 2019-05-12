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
|userid|int|用户标识，子增长|
|password|string||
|username|string||
|phone|string||
|name|string||
|authority|string|admin or roleuser|

### money表

|key|type|description|
|---|---|---|
|userid|int|用户标识|
|money|int|用户账上的钱|

### address表

> 对应用户地址

|key|type|description|
|---|---|---|
|userid|int||
|address|string||

### book表

|key|type|description|
|---|---|---|
|bookid|int||
|solder|int|userid|
|cost|float|价格为多少|
|normalcost|float|原价为多少|
|title|string||
|description|string|简介|
|soldenable|boolen|就是是否卖出去了|
|image|string|一个url|

### tags表

|key|type|description|
|---|---|---|
|tagid|int||
|tagname|string|tag的名字|

### booktag表

|key|type|description|
|---|---|---|
|bookid|int||
|tagid|int||

### money表

> 记录充钱与消费记录

|key|type|description|
|---|---|---|
|userid|int|用户标识|
|behavior|string|充钱还是消费,recharge , consumption|
|money|float||
|date|string|时间|

### record表

> 书的购买记录

|key|type|description|
|----|---|---|
|date|string|时间|
|buyid|int|每一个标识,自增长|
|userid|int||
|bookid|int||
|address|string|用户选的地址|
|bookcost|float|购买的书籍的价格|
|booksolderid|int|售书者的id|
|buyerphone|string|用户的联系方式|

## api接口通信规范

### 用户登陆模块

#### 登陆
api:

**传入**

|key|type|
|----|---|
|username|string|
|password|string|

**response**

|key|type||
|---|---|---|
|userid|int||
|name|string|用户名字而不是登录username|
|useremail|string||
|userphone|string||
|usermoney|float|钱数|

#### 注册
api:

**传入**

|key|type|description|
|---|---|---|
|username|string||
|password|string||
|name|string||
|phone|string||

**返回**

|key|type|description|
|---|---|---|
|state|string|'success','error'|
|info|string|if state is error, the error information|

### 书籍列表

#### 获得书籍列表

api:

**传入**

|key|type|description|
|---|---|---|
|userid|int||
|tagname|string|不同的标签对应获得不同的书籍列表|

> "all" 表示任意的 ， 某个"tag"表示对应的书籍列表 ， "recommend"表示的是获得推荐的书籍列表


**返回**

|key|type|description|
|---|---|---|
|state|string|'success' or error|
|nums|int|the num of book|
|books|list|书籍列表|

**every book**

|key|type|description|
|---|---|---|
|bookid|int||
|soldername|string||
|cost|float|价格为多少|
|normalcost|float|原价为多少|
|title|string||
|description|string|简介|
|image|string|一个url|

**for example**
```json
{
    "state":"success",
    "nums":1,
    "booklist":[
        {
            "bookid":1,
            "slodername":"langman",
            "cost":90,
            "normalcost":100,
            "title":"c++ prime",
            "description":"the most expensive book",
            "image":"https://langmanxu.cn"
        }
    ]
}
```

#### 查询某个关键字的书籍
api:
> 目前查询的话主要在于title,content进行匹配。

**传入**
|key|type|description|
|---|---|---|
|userid|int||
|keyword|string|关键字|

**传出**

和上面传出来的一样

### 钱搭边的

#### 充钱
api:

**传入**

|key|type|description|
|---|---|---|
|userid|int||
|money|||

**返回**

|key|type|description|
|---|---|---|
|state|string|'success','error'|

#### 购买

api:

**传入**

|key|type|description|
|----|---|---|
|userid|int||
|bookid|int||
|date|string||
|address|string|用户选择的地址|

**返回**

|key|value|description|
|---|---|---|
|state|string|"success" or "error"|

#### 购买记录
api:

**传入**

|key|type|description|
|---|---|---|
|userid|int||

**传出**

|key|type|description|
|---|---|---|
|bookname|string||
|bookimage|string||
|bookcost|float||
|isCorrect|bollen|就是说是否确认了，只有确认后，钱才到卖家手上|
|date|string|交易日期|


#### 出售记录
api:

**传入**

|key|type|description|
|----|---|---|
|userid|int||

**传出**

|key|type|description|
|----|----|----|
|bookname|string||
|bookcost|string||
|bookimage|string||
|isSolded|boolen|是否有人买了|
|buyername|string|买家姓名,上面的那个为false就为空|
|buyaddress|string||
|buyerphone|string||
|date|string||
|isCorrect|bollen|买家是否确认|

>  

### 上传书籍
api:

**传入**

|key|type|description|
|----|----|----|
|solder|int||
|cost|float|价格为多少|
|normalcost|float|原价多少|
|title|string||
|description|string||
|image|string|url|

**传出**

|key|type|desctrption|
|---|---|---|
|state|string||

## 界面设计

### 主界面

### 单个书籍详细界面

### 查询返回界面

### 用户自己界面

+ 每个用户都有两个窗口，一个是购买记录
+ 一个是出售记录

### 管理员界面

+ 所有用户的购买记录
+ 充钱