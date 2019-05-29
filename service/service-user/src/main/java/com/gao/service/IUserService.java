package com.gao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gao.entity.po.User;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-27
 */
public interface IUserService extends IService<User> {

    User selectByUserName(String username);
}
