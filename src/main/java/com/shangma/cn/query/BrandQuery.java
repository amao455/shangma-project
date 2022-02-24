package com.shangma.cn.query;

import com.shangma.cn.query.base.BaseQuery;
import lombok.Data;

@Data
public class BrandQuery extends BaseQuery {
    private String brandName;
    private String brandDesc;
}
