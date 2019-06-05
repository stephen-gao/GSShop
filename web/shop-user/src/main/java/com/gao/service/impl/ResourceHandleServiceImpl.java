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
        root.setId("0");
        root.setName("根节点");
        root.setCode("root");
        root = buildResTree(root,resources);
        List<ResourceVO> roots = new ArrayList<>();
        roots.add(root);
        return ResultFactory.getDataResult(roots);
    }

    private ResourceVO buildResTree(ResourceVO root, List<Resource> resources){
        List<ResourceVO> children = new ArrayList<>();
        ResourceVO child;
        for (Resource r : resources) {
            if (root.getId().equals(r.getParentId())) {
                child = new ResourceVO();
                BeanUtils.copyProperties(r, child);
                if("0".equals(child.getType())){
                    buildResTree(child,resources);
                }
                children.add(child);
            }
        }
        root.setChildren(children);
        return root;
    }
}
