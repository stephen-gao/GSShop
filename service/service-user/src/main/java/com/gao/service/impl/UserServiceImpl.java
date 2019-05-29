package com.gao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.entity.po.User;
import com.gao.mapper.UserMapper;
import com.gao.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User selectByUserName(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        wrapper.ne("status" ,9);
        return this.getOne(wrapper);
    }
}
