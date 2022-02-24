package com.shangma.cn.query.base;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
/*
 * 文件说明：封装条件和分页查询的基类
 * */


@Data
public class BaseQuery {
    private int currentPage = 1;
    private int pageSize = 5;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
