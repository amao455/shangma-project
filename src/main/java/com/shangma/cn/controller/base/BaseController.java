package com.shangma.cn.controller.base;

import com.shangma.cn.common.http.AxiosResult;

public class BaseController {

    protected AxiosResult<Void> toAxios(int row){

        return row > 0 ? AxiosResult.success() : AxiosResult.error();
    }
}
