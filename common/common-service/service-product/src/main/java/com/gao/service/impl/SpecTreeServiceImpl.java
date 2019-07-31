package com.gao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.entity.vo.SpecTreeVO;
import com.gao.mapper.SpecTreeMapper;
import com.gao.entity.po.SpecTree;
import com.gao.service.ISpecTreeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@Service
public class SpecTreeServiceImpl extends ServiceImpl<SpecTreeMapper, SpecTree> implements ISpecTreeService {

    @Autowired
    private SpecTreeMapper specTreeMapper;

    @Override
    public List<SpecTreeVO> specTree(Integer type) {
        QueryWrapper<SpecTree> wrapper = new QueryWrapper();
        wrapper.eq("type",type);
        wrapper.orderByAsc("sort");
        List<SpecTree> list = specTreeMapper.selectList(wrapper);

        SpecTreeVO root = new SpecTreeVO();
        root.setId("0");
        root.setSpecValue("root");
        root.setSpecName(0==type?"商品属性树":"sku规格树");
        root.setType(type);

        root = buildTree(root,list);

        List<SpecTreeVO> roots = new ArrayList<>();
        roots.add(root);
        return roots;
    }

    private SpecTreeVO buildTree(SpecTreeVO root,List<SpecTree> list){
        List<SpecTreeVO> children = new ArrayList<>();
        SpecTreeVO vo = null;
        for(SpecTree po : list){
            if(root.getId().equals(po.getParentId())){
                vo = new SpecTreeVO();
                BeanUtils.copyProperties(po,vo);
                vo = buildTree(vo,list);
                children.add(vo);
            }
        }
        root.setChildren(children);
        return root;
    }
}
