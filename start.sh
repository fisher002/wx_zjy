#! /bin/bash

# 安装所有模块
mvn clean install

# 启动接入程序
cd zjy
mvn  spring-boot:start

# 启动关注程序
cd ../subscribe
mvn  spring-boot:start

# 启动取消关注程序
cd ../unsubscribe
mvn  spring-boot:start

# 启动菜单管理模块
cd ../self_menu
mvn  spring-boot:start
