#! /bin/bash

# 停止接入程序
cd zjy
mvn  spring-boot:stop

# 停止关注程序
cd ../subscribe
mvn  spring-boot:stop

# 停止取消关注程序
cd ../unsubscribe
mvn  spring-boot:stop

# 启动菜单管理模块
cd ../self_menu
mvn  spring-boot:stop

# 启动菜单管理模块
cd ../library
mvn  spring-boot:stop