package com.shangma.cn.DTO.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
/*
* 文件说明：统一返回前端数据格式的基类
* */

@Data
public class BaseDTO {

    private Long  id;

    @JsonIgnore  //表示转json时，忽略这个属性
    private Long createBy;

    @JsonIgnore
    private Long updateBy;

    @JsonIgnore
    private LocalDateTime createTime;

    @JsonIgnore
    private LocalDateTime updateTime;
}
