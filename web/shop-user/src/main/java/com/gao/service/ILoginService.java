package com.gao.service;

import com.gao.base.result.Result;
import com.gao.entity.po.User;
import com.gao.entity.vo.UserVO;

/**
 * @Author gs
 * @Date created time 2019/5/28 12:07
 * @Description
 */
public interface ILoginService {

    Result<UserVO> login(User user);

    Result<UserVO> logout(String token);

}
