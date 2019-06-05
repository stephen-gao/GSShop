package com.gao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gao.entity.po.User;
import com.gao.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author gaosheng
 * @since 2019-05-27
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserVO> pageList(IPage page, @Param("ew")QueryWrapper wrapper);
}