package com.gao.service;

import com.gao.base.result.Result;
import com.gao.entity.vo.RoleVO;

/**
 * @Author gs
 * @Date created time 2019/6/4 12:58
 * @Description
 */
public interface IRoleHandleService {

    void addRole(RoleVO vo);

    Result getRole(String id);

    void updateRole(RoleVO vo);

    void delRole(String id);
}
