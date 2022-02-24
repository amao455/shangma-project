package com.shangma.cn.DTO;

import com.shangma.cn.DTO.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BrandDTO extends BaseDTO {

    private String brandName;
    private String brandSite;
    private String brandDesc;
    private String brandLogo;
}
