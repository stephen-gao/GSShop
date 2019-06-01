package com.gao.service.impl;

import com.gao.base.result.Result;
import com.gao.base.result.ResultFactory;
import com.gao.entity.po.Resource;
import com.gao.entity.vo.ResourceVO;
import com.gao.service.IResourceHandleService;
import com.gao.service.IResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ResourceHandleServiceImpl implements IResourceHandleService {

    @Autowired
    private IResourceService resourceService;

    @Override
    public Result resourceTree() {
        List<Resource> resources = resourceService.list();
        ResourceVO root = new ResourceVO();
        for (Resource r : resources) {
            if ("0".equals(r.getParentId())) {
                BeanUtils.copyProperties(r, root);
            }
        }
        List<ResourceVO> child = new ArrayList<>();
        ResourceVO node;
        for (Resource r : resources) {
            if (root.getId().equals(r.getParentId())) {
                node = new ResourceVO();
                BeanUtils.copyProperties(r, node);
                child.add(node);
            }
        }
        List<ResourceVO> child_2;
        for (ResourceVO rv : child) {
            child_2 = new ArrayList<>();
            for(Resource r : resources){
                if(rv.getId().equals(r.getParentId())){
                    node = new ResourceVO();
                    BeanUtils.copyProperties(r,node);
                    child_2.add(node);
                }
            }
            rv.setChildren(child_2);
        }
        root.setChildren(child);
        List<ResourceVO> roots = new ArrayList<>();
        roots.add(root);
        return ResultFactory.getDataResult(roots);
    }
}
