# 图书馆项目
## 项目简介
本项目是基于 Springboot + Sa-Token 实现的图书馆项目，实现了用户登录控制、访问权限控制和图书管理。

## 项目技术栈
* Springboot
* [Sa-Token](https://sa-token.cc/index.html)
* [Mybatis-plus](https://baomidou.com/)
* Redis
* Swagger3

## 项目部署
### 1. Mysql数据库（docker方式）
1. 下载镜像
`docker pull mysql:5.7.41`
2. 启动镜像
`docker run --name library-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7.41 
   --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci`
3. 登录数据库（root/123456）
4. 执行sql语句（路径：./doc/library.sql）

### 2. Redis（docker方式）
1. 下载镜像
`docker pull redis:7.0.8`
2. 启动镜像(指定配置文件，路径：./doc/redis.conf)
```
   docker run -p 6379:6379 --name library-redis \
   -v 宿主机中的RDB文件存放路径/redis/data:/data \
   -v 宿主机中的配置文件存放路径/redis.conf:/etc/redis/redis.conf \
   -d redis:7.0.8 redis-server /etc/redis/redis.conf
```

### 3. 启动应用
1. 修改 resource/application-test.yml 中对应的redis、mysql的host/port配置
2. 启动应用

### 4. 接口演示
http://localhost:8080/swagger-ui/index.html