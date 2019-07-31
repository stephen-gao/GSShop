package com.gao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gao.entity.po.SpecTree;
import com.gao.entity.vo.SpecTreeVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-29
 */
public interface ISpecTreeService extends IService<SpecTree> {

    List<SpecTreeVO> specTree(Integer type);

}
