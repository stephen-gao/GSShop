package com.gao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gao.entity.po.Category;
import com.gao.entity.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
public interface ICategoryService extends IService<Category> {

    List<CategoryVO> getCategoryTree();
}
