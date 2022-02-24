package com.shangma.cn.controller;

import com.github.pagehelper.PageHelper;
import com.shangma.cn.DTO.BrandDTO;
import com.shangma.cn.common.http.AxiosResult;
import com.shangma.cn.common.page.PageBean;
import com.shangma.cn.controller.base.BaseController;
import com.shangma.cn.entity.Brand;
import com.shangma.cn.query.BrandQuery;
import com.shangma.cn.service.BrandService;
import com.shangma.cn.transfer.BrandTransfer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
@Api(tags = "品牌管理", description = "品牌管理")
public class BrandController extends BaseController{
    /*
    swagger2 通过配置+注解的方式 自动生成接口文档
    * */
    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandTransfer brandTransfer;


    @ApiOperation(value = "分页条件查询")
    @GetMapping("searchPage")
    public AxiosResult<PageBean<BrandDTO>> searchPage(BrandQuery brandQuery) {
        // 开启分页
        PageHelper.startPage(brandQuery.getCurrentPage(), brandQuery.getPageSize());
        PageBean<BrandDTO> pageBean = brandService.searchPage(brandQuery);
        return AxiosResult.success(pageBean);
    }

    @ApiOperation(value = "查询所有")
    @GetMapping
    public AxiosResult<List<BrandDTO>> list(){
        return AxiosResult.success(brandService.list());
    }

    @ApiOperation(value = "id查询")
    @ApiImplicitParam(required = true, value = "品牌id")
    @GetMapping("{id}")
    private AxiosResult<BrandDTO> findById(@PathVariable Long id){
        return AxiosResult.success(brandTransfer.toDTO(brandService.findById(id)));
    }

    @ApiOperation(value = "添加品牌")
    @PostMapping
    public AxiosResult<Void> add(@RequestBody Brand brand){
        return toAxios(brandService.add(brand));
    }

    @ApiOperation(value = "修改品牌")
    @PutMapping
    public AxiosResult<Void> update(@RequestBody Brand brand){
        return toAxios(brandService.update(brand));
    }

    @ApiOperation(value = "通过id删除")
    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable Long id){
        return toAxios(brandService.deleteById(id));
    }

    @ApiOperation(value = "通过id批量删除")
    @DeleteMapping("batch/{ids}")
    public AxiosResult<Void> batchDeleteByIds(@PathVariable List<Long> ids){
        return toAxios(brandService.batchDeleteByIds(ids));
    }

}
