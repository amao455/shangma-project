package com.shangma.cn.service.base;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shangma.cn.entity.Brand;

import java.util.List;

public interface BaseService<T> {
    /*
   查询所有
    */
    public List<T> list();

    /*
    条件分页查询
     */
    //List<T> search(LambdaQueryWrapper<T> queryWrapper);

    /*
    通过id查询
     */
    T findById(Long id);

    /*
    添加
     */
    int add(T t);

    /*
    修改
     */
    int update(T t);

    /*
    删除
     */
    int deleteById(Long id);

    /*
    批量删除
     */
    int batchDeleteByIds(List<Long> ids);

}
