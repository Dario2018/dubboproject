package com.dario.dubboconsumer.controller;

import com.dario.dubbocommons.constant.DubboVersionConstant;
import com.dario.dubboredisapi.service.RedisService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redisapi")
public class TestRedisController {


    @Reference(version = DubboVersionConstant.DUBBO_VERSION_API_ADMIN)
    private RedisService redisService;



    @ApiOperation(value = "获取Redi缓存列表", notes = "获取提供key", httpMethod = "GET", response = Map.class)
    @ApiImplicitParam(name = "key", value = "获取的键", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "get/{key}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable(value = "key", required = true) String key) {
        Map<String, Object> result = new HashMap<>(3);
        result.put("code", 200);
        result.put("data", redisService.get(key));
        result.put("msg", "成功");
        return result;
    }

    @ApiOperation(value = "往Redi缓存设值", notes = "字符类型", httpMethod = "GET", response = Map.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",value = "键",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "value",value = "值",required = true,dataType = "String",paramType = "path")
    })
    @RequestMapping(value = "set/{key}/{value}", method = RequestMethod.GET)
    public Map<String, Object> set(@PathVariable(value = "key", required = true) String key,@PathVariable(value = "value",required = true) String value) {
        Map<String, Object> result = new HashMap<>(3);
        result.put("code", 200);
        result.put("data", redisService.set(key,value,2000));
        result.put("msg", "成功");
        return result;
    }

}
