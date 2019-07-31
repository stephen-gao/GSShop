package com.gao.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.entity.vo.CategoryVO;
import com.gao.mapper.CategoryMapper;
import com.gao.entity.po.Category;
import com.gao.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 分类表  服务实现类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<CategoryVO> getCategoryTree() {
        QueryWrapper<Category> wrapper = new QueryWrapper();
        wrapper.orderByAsc("sort");
        List<Category> list = categoryMapper.selectList(wrapper);
        CategoryVO root = new CategoryVO();
        root.setId("0");
        root.setCategoryName("根节点");
        root.setSort(1);

//        Iterator<Category> it = list.iterator();

        root = buildTree(root,list);

        List<CategoryVO> roots = new ArrayList<>();
        roots.add(root);
        return roots;
    }

    private CategoryVO buildTree(CategoryVO root, List<Category> list){

        CategoryVO vo = null;
        List<CategoryVO> children = new ArrayList<>();
        for (Category po : list){
            if(root.getId().equals(po.getParentId())){
                vo = new CategoryVO();
                BeanUtils.copyProperties(po,vo);
                vo = buildTree(vo,list);
                children.add(vo);
            }
        }
        root.setChildren(children);
        return root;
    }
}
