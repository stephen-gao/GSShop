package com.gao.service.impl;

import com.gao.entity.po.Resource;
import com.gao.mapper.ResourceMapper;
import com.gao.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-31
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {
	
}
