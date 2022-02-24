package com.shangma.cn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shangma.cn.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

    /*
    * 把实体类分层：
    *   1： 负责查询时的参数接收相关实体类  BaseQuery
    *   2： 负责添加修改接收的实体类()Brand和数据库对应
    *   3： 返回前端需要的实体类 VO DTO
    * */

@TableName(value = "t_brand")
@Data
@ApiModel(value = "品牌实体")
public class Brand extends BaseEntity {


    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    @ApiModelProperty(value = "品牌站点")
    private String brandSite;
    @ApiModelProperty(value = "品牌LOGO")
    private String brandDesc;
    @ApiModelProperty(value = "品牌描述")
    private String brandLogo;


}
