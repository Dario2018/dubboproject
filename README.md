#### Dubbo 项目结构说明

#### dubbodependencies
   - 是整个项目的基础依赖，其他以它为parent
   - 打包成pom包
   
#### dubbocommons
   - 依赖于dubbodependencies模块
   - 适用于整个项目的常量应该放在这个模块下

#### dubboproviderapi
   - 对外提供服务的
   - 依赖于dubboproviderdomain

#### dubboproviderdomain
   - 保存实体类的模块
   
#### dubboprovider
   - 依赖于dubbocommons
   - 依赖于dubboproviderapi
   - service 逻辑实现模块
   - 生产者，容器
#### 构建服务监控中心注意事项
#### 参考链接：https://blog.csdn.net/u010565545/article/details/103886903
   
### 对于dubbo-admin mvn clean package/mvn clean install 出现报KeeperErrorCode = ConnectionLoss异常 解决方法
#### 通过升级 zookeeper:3.4.14 其他版本的也有坑
   - <curator-version>2.12.0</curator-version> 为
   - <curator-version>4.3.0</curator-version>

### 访问链接
   - http://localhost:9000/swagger-ui.html#/condition-routes-controller
   - http://localhost:9000/#/
   - http://localhost:8088/swagger-ui.html
   - http://localhost:8088/api/v1/consumer/list/goods/1/10
   - http://localhost:8088/redisapi/get/{key}
   - http://localhost:8088/redisapi/set/{key}/{value}

### bin ：模块中存放的maven打包命令:mymvn.bat clean install
### data ：模块中存放的是数据库

#### dubbouser 用户中心
   - 使用MyBatis插件自动生成代码
   - dubbouser 登录模块总结：
      - （1）注意url权限的配置 ，只需要从controller里面开始就可以了，不必管yml 中配置context-path前置属性，只需知道访问前要先带上其即可
      - （2）注意controller里面类上访问url是在requestmapping注解中，而不是在restcontroller注解中，这个错误犯下不知一次了，这次报Unauthorized错误，401没有权限错误，找问题花了很长时间。谨此教训
      - （3）新增的功能有对大多请求的url需要授权才可以访问的
      - （4）配置log日志，打印输出sql语句，配置令牌密钥，过期时间为5小时。
      - （5）修改了原来的数据表
   - 后期规划：
      - 加入vue前端项目 
#### [springboot 参考项目](https://github.com/fishpro/spring-boot-study)