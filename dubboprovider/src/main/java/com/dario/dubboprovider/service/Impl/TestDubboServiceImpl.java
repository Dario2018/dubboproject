package com.dario.dubboprovider.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dario.dubbocommons.constant.DubboVersionConstant;
import com.dario.dubboprovider.mapper.TestDubboMapper;
import com.dario.providerapi.TestDubboService;
import com.dario.providerdomain.TestDubbo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = DubboVersionConstant.DUBBO_VERSION_API_ADMIN)
public class TestDubboServiceImpl implements TestDubboService {

    @Autowired
    private TestDubboMapper testDubboMapper;

    @Override
    public List<TestDubbo> findAll() {
        return testDubboMapper.selectAll();
    }
}
