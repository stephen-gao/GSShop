package com.gao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gao.mapper.CategoryMapper;
import com.gao.entity.po.Category;
import com.gao.service.ICategoryService;
import org.springframework.stereotype.Service;

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
	
}
