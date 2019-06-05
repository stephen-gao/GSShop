package com.gao.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gao.entity.po.SysDicItem;
import com.gao.entity.po.SysDicType;
import com.gao.entity.vo.SysDicVO;

import java.util.List;


public interface ISysDicService {

    IPage sysDicTypePage(SysDicVO vo);

    JSON sysDicTree();

    List sysDicTypeList();

    List sysDicItemList();

    void addSysDicType(SysDicType po);

    void delSysDicType(String id);

    void addSysDicItem(SysDicItem po);

    void delSysDicItem(String id);

    List sysDicItemListByTypeId(String typeId);

    List sysDicItemListByTypeCode(String typeCode);

}
