package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.CategoryMapper;
import com.lsm.frame.model.entity.Category;
import com.lsm.frame.service.intf.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.CachedRowSet;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
