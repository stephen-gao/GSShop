package com.gao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gao.entity.po.CustomerLogin;
import com.gao.entity.vo.CustomerVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaosheng
 * @since 2019-06-06
 */
public interface ICustomerLoginService extends IService<CustomerLogin> {

    void changePwd(CustomerLogin po);
}
