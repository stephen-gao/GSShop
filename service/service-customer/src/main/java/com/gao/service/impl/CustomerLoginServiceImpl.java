package com.gao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.base.utils.MD5;
import com.gao.base.utils.SaltUtils;
import com.gao.entity.po.CustomerLogin;
import com.gao.entity.vo.CustomerVO;
import com.gao.mapper.CustomerLoginMapper;
import com.gao.service.ICustomerLoginService;
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
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements ICustomerLoginService {

    @Autowired
    private CustomerLoginMapper customerLoginMapper;

    @Override
    public void changePwd(CustomerLogin po) {
        String salt = SaltUtils.getSalt();
        String encrypt = MD5.encrypt(po.getPassword(),"",salt);
        po.setPassword(encrypt);
        po.setSalt(salt);
        Date date = new Date();
        po.setGmtUpdate(date);
        customerLoginMapper.updateById(po);
    }
}
