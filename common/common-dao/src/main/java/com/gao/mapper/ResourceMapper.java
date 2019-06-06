package com.gao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gao.entity.po.Resource;
import com.gao.entity.vo.ResourceVO;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-31
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    List<ResourceVO> getUserMenu(String userId);
}