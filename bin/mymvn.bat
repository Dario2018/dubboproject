@REM 批量 clean 或者 install
@echo off
@echo param1=%1
@echo param2=%2
@REM 准备遍历项目目录
cd ..
cd dubbodependencies
call mvn clean install
cd ..
cd dubbocommons
call mvn clean install
cd ..
cd dubboproviderdomain
call mvn clean install
cd ..
cd dubboproviderapi
call mvn clean install
cd ..
cd dubboprovider
call mvn clean install
cd ..
cd dubboconsumer
call mvn clean install
cd ..
cd bin
@echo off
@echo off