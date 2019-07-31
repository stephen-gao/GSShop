package com.gao.service;

import com.gao.base.result.Result;
import com.gao.entity.vo.UserVO;

/**
 * @Author gs
 * @Date created time 2019/6/4 17:20
 * @Description
 */
public interface IUserHandleService {

    Result userPage(UserVO vo);

    void addUser(UserVO vo);

    void updUser(UserVO vo);

    Result get(String id);

    void del(String id);

}
