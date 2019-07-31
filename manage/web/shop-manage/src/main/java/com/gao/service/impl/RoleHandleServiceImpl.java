package com.gao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gao.base.result.Result;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.Resource;
import com.gao.entity.po.Role;
import com.gao.entity.po.RoleResource;
import com.gao.entity.vo.RoleVO;
import com.gao.service.IRoleHandleService;
import com.gao.service.IRoleResourceService;
import com.gao.service.IRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author gs
 * @Date created time 2019/6/4 12:58
 * @Description
 */
@Service
public class RoleHandleServiceImpl implements IRoleHandleService {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRoleResourceService roleResourceService;


    @Override
    @Transactional
    public void addRole(RoleVO vo) {
        Date date = new Date();
        Role po = new Role();
        BeanUtils.copyProperties(vo, po);
        po.setGmtCreate(date);
        po.setGmtUpdate(date);
        roleService.save(po);
        saveRoleResources(vo.getResources(), po.getId());
    }

    @Override
    public Result getRole(String id) {
        Role role = roleService.getById(id);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id", id);
        List<RoleResource> list = roleResourceService.list(wrapper);
        List<String> resourceIds = new ArrayList<>();
        for (RoleResource rr : list) {
            resourceIds.add(rr.getResourceId());
        }
        RoleVO vo = new RoleVO();
        BeanUtils.copyProperties(role, vo);
        vo.setResourceIds(resourceIds);
        return ResultFactory.getDataResult(vo);
    }

    @Override
    @Transactional
    public void updateRole(RoleVO vo) {
        Date date = new Date();
        Role po = new Role();
        BeanUtils.copyProperties(vo, po);
        po.setGmtUpdate(date);
        roleService.updateById(po);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id",po.getId());
        roleResourceService.remove(wrapper);
        saveRoleResources(vo.getResources(), po.getId());
    }

    @Override
    @Transactional
    public void delRole(String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id",id);
        roleResourceService.remove(wrapper);
        roleService.removeById(id);
    }

    private void saveRoleResources(List<Resource> list, String roleId) {
        if (!CollectionUtils.isEmpty(list)) {
            RoleResource rr = new RoleResource();
            for (Resource r : list) {
                rr.setRoleId(roleId);
                rr.setResourceId(r.getId());
                rr.setResourceCode(r.getCode());
                roleResourceService.save(rr);
            }
        }
    }
}
