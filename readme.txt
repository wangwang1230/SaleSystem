基于SSM+MYSQL的一个小型商城网站后台管理系统
商城后台管理系统

运行环境：jdk1.6+tomcat7+mysql

数据库脚本：

地址1:链接:https://pan.baidu.com/s/1eSs8YCM 密码:98dv

地址2:链接: https://pan.baidu.com/s/1hsKptm0 密码: 2dae

jar包(上传限制20M以内)：

地址1:链接:https://pan.baidu.com/s/1eSs8YCM 密码:98dv

地址2:链接: https://pan.baidu.com/s/1hss4S08 密码: ir1b

本项目是一个简单的基于SSM框架的小型商城的后台管理系统，主要实现用户模块和信息模块。

用户模块包括：用户管理、角色管理、权限管理

信息模块包括：咨询管理、公告管理、留言管理

用到了redis缓存技术，interceptor拦截器实现权限控制

部署注意问题：
部署项目后，样式失效，js失效，检查页面是否报错，应该是Tomcat路径问题，Tomcat默认路径为自定义的root,所以更改Tomcat默认路径为当前web项目即可