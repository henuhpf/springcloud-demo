- 使用 idea 开发项目时，idea遇到了异常退出，而之前启动的项目仍在启动

解决方法: 使用 jps 命令，输出的第一列为 PID ，找到相应的项目并输入 taskkill /pid PID /f 即可关闭该服务

