package com.gao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.entity.po.CustomerInfo;
import com.gao.entity.po.CustomerLogin;
import com.gao.mapper.CustomerInfoMapper;
import com.gao.mapper.CustomerLoginMapper;
import com.gao.service.ICustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author gaosheng
 * @since 2019-06-06
 */
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements ICustomerInfoService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private CustomerLoginMapper customerLoginMapper;

    @Override
    public void changeState(String id, String loginId, String state) {
        CustomerInfo ci = new CustomerInfo();
        CustomerLogin cl = new CustomerLogin();
        Date date = new Date();
        ci.setId(id);
        ci.setState(state);
        ci.setGmtUpdate(date);
        cl.setId(loginId);
        cl.setState(state);
        cl.setGmtUpdate(date);
        customerInfoMapper.updateById(ci);
        customerLoginMapper.updateById(cl);
    }
}
