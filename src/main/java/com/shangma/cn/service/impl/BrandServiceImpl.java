package com.shangma.cn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageInfo;
import com.shangma.cn.DTO.BrandDTO;
import com.shangma.cn.common.page.PageBean;
import com.shangma.cn.entity.Brand;
import com.shangma.cn.mapper.BrandMapper;
import com.shangma.cn.query.BrandQuery;
import com.shangma.cn.service.BrandService;
import com.shangma.cn.service.base.impl.BaseServiceImpl;
import com.shangma.cn.transfer.BrandTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
* 两个实体类的属性值互换：
*
* */

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandTransfer brandTransfer;

    @Override
    public PageBean<BrandDTO> searchPage(BrandQuery brandQuery) {
        LambdaQueryWrapper<Brand> lambda = new QueryWrapper<Brand>().lambda();
        if(!StringUtils.isEmpty(brandQuery.getBrandName())){
            lambda.like(Brand::getBrandName, brandQuery.getBrandName());
        }
        if(!StringUtils.isEmpty(brandQuery.getBrandDesc())){
            lambda.like(Brand::getBrandDesc, brandQuery.getBrandDesc());
        }
        if (Objects.nonNull(brandQuery.getStartTime()) && Objects.nonNull(brandQuery.getEndTime())) {

            lambda.between(Brand::getCreateTime, brandQuery.getStartTime(),brandQuery.getEndTime());
        }

        lambda.orderByDesc(Brand::getId);
        List<Brand> brands = super.search(lambda);

        //List<Brand> brands = brandMapper.selectList(lambda);

        PageInfo<Brand> pageInfo = new PageInfo<>(brands);

        //List<BrandDTO> list = new ArrayList<>();


        List<BrandDTO> brandDTOS = brandTransfer.toDTO(brands);

        return PageBean.initData(pageInfo.getTotal(), brandDTOS);

    }
}
