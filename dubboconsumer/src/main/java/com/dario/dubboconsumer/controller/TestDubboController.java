package com.dario.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dario.dubbocommons.constant.DubboVersionConstant;
import com.dario.providerapi.TestDubboService;
import com.dario.providerdomain.TestDubbo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
public class TestDubboController {

    @Reference(version = DubboVersionConstant.DUBBO_VERSION_API_ADMIN)
    private TestDubboService testDubboService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<TestDubbo> list(){
        return testDubboService.findAll();
    }
}
