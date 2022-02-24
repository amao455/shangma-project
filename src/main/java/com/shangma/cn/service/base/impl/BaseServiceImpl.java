package com.shangma.cn.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangma.cn.mapper.base.MyMapper;
import com.shangma.cn.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private MyMapper<T> myMapper;

    @Override
    public List<T> list() {
        return myMapper.selectList(null);
    }

    @Override
    public List<T> search(LambdaQueryWrapper<T> queryWrapper) {
        return myMapper.selectList(queryWrapper);
    }

    @Override
    public T findById(Long id) {
        return myMapper.selectById(id);
    }

    @Override
    public int add(T t) {
        return myMapper.insert(t);
    }

    @Override
    public int update(T t) {
        return myMapper.updateById(t);
    }

    @Override
    public int deleteById(Long id) {
        return myMapper.deleteById(id);
    }

    @Transactional //该方法开启事务
    @Override
    public int batchDeleteByIds(List<Long> ids) {
        return myMapper.deleteBatchIds(ids);
    }
}
