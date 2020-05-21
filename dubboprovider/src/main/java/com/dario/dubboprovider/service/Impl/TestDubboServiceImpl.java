package com.dario.dubboprovider.service.Impl;

import com.dario.dubbocommons.constant.DubboVersionConstant;
import com.dario.dubboprovider.mapper.TestDubboMapper;
import com.dario.providerapi.TestDubboService;
import com.dario.providerdomain.TestDubbo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * timeout:方法调用超时
 * retries:失败重试次数
 * loadbalance:负载均衡算法
 * actiives:消费者端最大并发调用限制
 */
@Service(registry = "zookeeper", timeout = 6000, retries = 3, loadbalance = "random", actives = 10, version = DubboVersionConstant.DUBBO_VERSION_API_ADMIN)
public class TestDubboServiceImpl implements TestDubboService {

    @Autowired
    private TestDubboMapper testDubboMapper;

    @Override
    public List<TestDubbo> findAll() {
        return testDubboMapper.selectAll();
    }
}
