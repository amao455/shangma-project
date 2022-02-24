package com.shangma.cn.service;

import com.shangma.cn.DTO.BrandDTO;
import com.shangma.cn.common.page.PageBean;
import com.shangma.cn.entity.Brand;
import com.shangma.cn.query.BrandQuery;
import com.shangma.cn.service.base.BaseService;

public interface BrandService extends BaseService<Brand> {


    /*
    * 条件查询
    * */
    PageBean<BrandDTO> searchPage(BrandQuery brandQuery);
}
