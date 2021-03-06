package com.gao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gao.entity.po.Brand;
import com.gao.mapper.BrandMapper;
import com.gao.service.IBrandService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
	
}
