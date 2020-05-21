package com.dario.dubboconsumer.controller;

import com.dario.dubbocommons.constant.DubboVersionConstant;
import com.dario.providerapi.TestDubboService;
import com.dario.providerdomain.TestDubbo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "${rest.path.api.v1}/consumer")
public class TestDubboController {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_API_ADMIN)
    private TestDubboService testDubboService;


    @ApiOperation(value = "获取提供者列表",notes = "获取提供者分页列表",httpMethod = "GET",response = List.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页码",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "pageSize",value = "页大小",required = true,dataType = "int",paramType = "path")
    })
    @RequestMapping(value = "list/{type}/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public List<TestDubbo> list(@PathVariable(value = "type",required = true) String type,
                                @PathVariable(value = "pageNum",required = true) int pageNum,
                                @PathVariable(value = "pageSize",required = true) int pageSize){
        return testDubboService.findAll();
    }
}
