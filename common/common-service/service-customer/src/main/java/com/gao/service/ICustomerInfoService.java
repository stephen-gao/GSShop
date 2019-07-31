package com.gao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gao.entity.po.CustomerInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaosheng
 * @since 2019-06-06
 */
public interface ICustomerInfoService extends IService<CustomerInfo> {

    void changeState(String id,String loginId,String State);
}
