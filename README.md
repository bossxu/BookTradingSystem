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
|sex|string||
|money|double||

### address表

> 对应用户地址

|key|type|description|
|---|---|---|
|addid|int||
|zipcode|string|邮政编码|
|addressdetail|string|地址细节|

### book表

|key|type|description|
|---|---|---|
|bookid|int|自增长|
|solder|int|userid|
|cost|float|价格为多少|
|normalcost|float|原价为多少|
|title|string||
|description|string|简介|
|soldenable|boolen|就是是否卖出去了|
|image|string|书皮|

### tags表

|key|type|description|
|---|---|---|
|tagid|int||
|tagname|string|tag的名字|


### moneyRecord表

> 记录充钱与消费记录

|key|type|description|
|---|---|---|
|id|int|自增长|
|userid|int|用户标识|
|money|float||
|date|string|时间|

### record表

> 书的购买记录

|key|type|description|
|----|---|---|
|reid|int|自增长|
|date|string|时间|
|userid|int|外键|
|bookid|int|外键|
|solderid|int|外键|
|address|string|用户选的地址|
|bookcost|float|购买的书籍的价格|
|forsure|bollean|订单是否确认|

### shopingRecord表
> 购物车

|key|type|description|
|---|---|---|
|shopid|int|主键|
|date|string|时间|
|user_id|int|外键|
|book_id|int|外键|

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


## 具体的接口和通信规则

### user

#### 注册
api: **/api/user/regist**

```
postbody
{
	"username":"langman2",
	"name":"迪迦奥特曼",
	"password":"password",
	"phone":"10086",
	"sex":"男"
}
response
{"state":"success"}
or
{"state":"error","message":"用户已存在"}

```

#### 登陆
api:**/api/user/login**
```
postbody:
{
	"username":"langman3",
	"password":"password"
}
response:
{
    "response": {
        "userid": 3,
        "username": "langman3",
        "phone": "10086",
        "sex": "男",
        "name": "赛文奥特曼",
        "authority": "ROLE",
        "money": 0
    },
    "state": "success"
}
{
    "reponse": "密码错误",
    "state": "error"
}
{
    "response": "用户名不存在",
    "state": "error"
}
```

#### 获取某人的权限
api:**/api/user/authority/{id}**
```
get:
response:[String]
ROLE or Admin
```

#### 改密码
api:**/api/user/changepassword**
```
postbody:
{
	"userid":3,
	"password":"password1"
}
response:
{"state":"success"}
```

#### 获得所有用户
api: **/api/user/all**

```
getbody:
response:[
             {
                 "userid": 1,
                 "username": "langman1",
                 "phone": "10086",
                 "sex": "男",
                 "name": "泰罗奥特曼",
                 "authority": "ROLE",
                 "money": 0
             },
             {
                 "userid": 2,
                 "username": "langman2",
                 "phone": "10086",
                 "sex": "男",
                 "name": "迪迦奥特曼",
                 "authority": "ROLE",
                 "money": 0
             },
             {
                 "userid": 3,
                 "username": "langman3",
                 "phone": "10086",
                 "sex": "男",
                 "name": "赛文奥特曼",
                 "authority": "ROLE",
                 "money": 0
             }
         ]
```

#### 删除某个用户

api :**/api/user/delete/{id}** method:delete
return {state:success}

### book

#### 创建新的book
api:**/api/book/create**
```
postbody:
{
	"solder":3,
	"cost":89,
	"normalcost":100,
	"title":"苏轼文化",
	"description":"谁学谁秃",
	"image":"/user/local/images/2",
	"taglist":["文学系","教科书"]
    
    response:
    {"state":"success"}
}
```

#### 获得所有的书籍列表
api:**/api/book/create**
```
method = get
response
[
    {
        "bookid": 1,
        "cost": 89,
        "normalcost": 100,
        "title": "苏轼文化",
        "description": "谁学谁秃",
        "soldenable": false,
        "image": "/user/local/images/2"
    }
]
```

#### 获取某个用户上传的书
api:**/api/book/user/{userid}**
method = get
```
response:
[
    {
        "bookid": 1,
        "cost": 89,
        "normalcost": 100,
        "title": "苏轼文化",
        "description": "谁学谁秃",
        "soldenable": false,
        "image": "/user/local/images/2"
    }
]
```

#### 获取某个tag的书籍列表
api:**/api/book/tag/{tagid}**
method = get
```
response:
[
    {
        "bookid": 1,
        "cost": 89,
        "normalcost": 100,
        "title": "苏轼文化",
        "description": "谁学谁秃",
        "soldenable": false,
        "image": "/user/local/images/2"
    }
]
```

#### 获取书籍具体的信息
api = **/api/book/{bookid}**
method = get
```
response:
{
    "bookid": 1,
    "cost": 89,
    "normalcost": 100,
    "title": "苏轼文化",
    "description": "谁学谁秃",
    "image": "/user/local/images/2",
    "user": {
        "userid": 3,
        "phone": "10086",
        "sex": "男",
        "name": "赛文奥特曼"
    },
    "tagList": [
        {
            "tagid": 1,
            "tagname": "文学系"
        },
        {
            "tagid": 2,
            "tagname": "教科书"
        }
    ]
}
```

#### 书籍查询，基于tag加keyword tag必须是精确的
api = **/api/book/search**
method:get
```
getbody:
{
	"tagname":"",
	"keyword":"java"
}
response:
[
    {
        "bookid": 1,
        "cost": 89,
        "normalcost": 100,
        "title": "苏轼文化",
        "description": "谁学谁秃",
        "soldenable": false,
        "image": "/user/local/images/2"
    }
]
```

### 地址

#### 创建某人的一个地址
api:**/api/user/address/create**
```
postbody
{
	"userid":"1",
	"zipcode":"242500",
	"addressdetail":"安徽泾县"
}
response:
{"state":"success"}
```

#### 查询某个人的地址
api:**/api/user/address/{userid}**
method=get
```
response:
[
    {
        "addid": 1,
        "zipcode": "242500",
        "addressdetail": "安徽泾县"
    }
]
```

### 充钱方面的

#### 创建新的记录
api:**/api/money/create**
```
postbody:
{
	"money":100,
	"username":"langman1"
}
response
{"state":"success"}
```

#### 获取记录
api:**/api/money/{userid}**
```
get:
response:
[
    {
        "id": 1,
        "money": 100,
        "date": "2019-05-27 23:21:39"
    }
]
```

### 购物车的功能

#### 添加购物车
api:**/api/shop/create**
```
postbody:
{
	"bookid":1,
	"userid":1
}
response
{"state":"success"}
```

#### 获取某人的购物车记录
api: **/api/shop/user/{userid}**
```
get
response
[
    {
        "shopid": 1,
        "bookid": 0, //这个不用管
        "userid": 0, //不用管
        "date": "2019-05-27 23:30:40",
        "solderid": 3,
        "book": {
            "bookid": 1,
            "cost": 89,
            "normalcost": 100,
            "title": "苏轼文化",
            "description": "谁学谁秃",
            "soldenable": false,
            "image": "/user/local/images/2"
        }
    }
]
```

#### 删除某个物车记录
api:**/api/shop/delete/{shopid}**
```
delete:
response:
```

### 交易的模块

#### 创建交易
api:**/api/record/create**

逻辑是这样的，产生交易 ，买家扣钱，卖家钱不到账，
买家确认，钱到卖家手中。
```
postbody
{
	"bookid":1,
	"address":"安徽泾县",
	"bookcost":89,
	"buyid":2,
	"solderid":3
}
response: 这些类型
{
    "state": "error",
    "info": "钱不够啊"
}
{
    "state": "error",
    "info": "不能买自己的书"
}
{"state":"success"}

```

#### 确认订单
api:**/api/record/sure**
买家确定订单，或者到达一定的时间，自动会将买家的钱打入进卖家的手中
```
postbody:
{
	"reid":1,
	"bookid":1,
	"buyid":1,
	"solderid":3
}
response:
{"state":"success"}
{"state":"error","response":"已经确认过订单了"}
```

#### 作为买家获得所有订单信息
api:**/api/record/asbuyer/{userid}**
method:get
```
get:
response:
[
    {
        "reid": 1,
        "bookid": 1,
        "address": "安徽泾县",
        "bookcost": 89,
        "forsure": true,
        "date": "2019-05-27 23:40:35",
        "user": {
            "userid": 1,
            "phone": "10086",
            "sex": "男",
            "name": "泰罗奥特曼"
        },
        "solder": {
            "userid": 3,
            "phone": "10086",
            "sex": "男",
            "name": "赛文奥特曼"
        }
    }
]
```

#### 作为卖家
api:**/api/record/assolder/{id}**
method:get
```
response:
[
    {
        "reid": 1,
        "bookid": 1,
        "address": "安徽泾县",
        "bookcost": 89,
        "forsure": true,
        "date": "2019-05-27 23:40:35",
        "user": {
            "userid": 1,
            "phone": "10086",
            "sex": "男",
            "name": "泰罗奥特曼"
        },
        "solder": {
            "userid": 3,
            "phone": "10086",
            "sex": "男",
            "name": "赛文奥特曼"
        }
    }
]
```
