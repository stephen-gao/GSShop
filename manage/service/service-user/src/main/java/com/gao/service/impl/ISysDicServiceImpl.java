package com.gao.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gao.entity.po.SysDicItem;
import com.gao.entity.po.SysDicType;
import com.gao.entity.vo.SysDicVO;
import com.gao.mapper.SysDicItemMapper;
import com.gao.mapper.SysDicTypeMapper;
import com.gao.service.ISysDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISysDicServiceImpl implements ISysDicService {

    @Autowired
    private SysDicTypeMapper sysDicTypeMapper;
    @Autowired
    private SysDicItemMapper sysDicItemMapper;


    @Override
    public IPage sysDicTypePage(SysDicVO vo) {
        IPage page = new Page();
        page.setCurrent(vo.getPageNum());
        page.setSize(vo.getPageSize());
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.orderByAsc("sort");
        return sysDicTypeMapper.selectPage(page,wrapper);
    }

    @Override
    public JSON sysDicTree() {
        List<SysDicType> types = sysDicTypeMapper.selectList(new QueryWrapper());
        List<SysDicItem> items = sysDicItemMapper.selectList(new QueryWrapper<>());
        JSONObject root = new JSONObject();
        JSONObject item;
        for(SysDicType sdt : types){
            item = new JSONObject();
            for(SysDicItem sdi : items){
                if(sdt.getId().equals(sdi.getTypeId())){
                    item.put(sdi.getCode(),sdi.getName());
                }
            }
            root.put(sdt.getCode(),item);
        }
        return root;
    }


    @Override
    public List sysDicTypeList() {
        QueryWrapper<SysDicType> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        return sysDicTypeMapper.selectList(wrapper);
    }

    @Override
    public List sysDicItemList() {
        QueryWrapper<SysDicItem> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        return sysDicItemMapper.selectList(wrapper);
    }

    @Override
    public void addSysDicType(SysDicType po) {
        sysDicTypeMapper.insert(po);
    }

    @Override
    public void delSysDicType(String id) {
        sysDicTypeMapper.deleteById(id);
    }

    @Override
    public void addSysDicItem(SysDicItem po) {
        sysDicItemMapper.insert(po);
    }

    @Override
    public void delSysDicItem(String id) {
        sysDicItemMapper.deleteById(id);
    }

    @Override
    public List sysDicItemListByTypeId(String typeId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type_id",typeId);
        wrapper.orderByAsc("sort");
        return sysDicItemMapper.selectList(wrapper);
    }

    @Override
    public List sysDicItemListByTypeCode(String typeCode) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("type_code",typeCode);
        wrapper.orderByAsc("sort");
        return sysDicItemMapper.selectList(wrapper);
    }
}
