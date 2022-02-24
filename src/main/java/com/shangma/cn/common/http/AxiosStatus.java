package com.shangma.cn.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AxiosStatus {
    OK(20000, "操作成功"),
    ERROR(44444, "操作失败"),

    ;
    private int status;
    private String message;

}
