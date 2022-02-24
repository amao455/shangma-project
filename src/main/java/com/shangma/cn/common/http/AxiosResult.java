package com.shangma.cn.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
//文件说明：统一返回值
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult<T> {

    private int status;
    private String message;
    private T data;

    private AxiosResult(AxiosStatus axiosStatus, T t){
        this.status = axiosStatus.getStatus();
        this.message =  axiosStatus.getMessage();
        this.data = t;
    }

    /*
    成功的方法
     */
    public static <T> AxiosResult<T> success(){
        return getInstance(AxiosStatus.OK, null);
    }

    /*
    成功的方法
    携带数据
     */
    public static <T> AxiosResult<T> success(T t){
        // getInstance():主函数当中使用此类的getInstance()函数，即可得到系统当前已经实例化的该类对象，若当前系统还没有实例化过这个类的对象，则调用此类的构造函数
        return getInstance(AxiosStatus.OK, t);
    }

    /*
    失败的方法
     */
    public static <T> AxiosResult<T> error(){
        return getInstance(AxiosStatus.ERROR, null);
    }

    /*
    自定义失败状态码
     */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus){
        return getInstance(axiosStatus, null);
    }

    /*
    自定义状态码和数据
     */
    public static <T> AxiosResult<T> error(AxiosStatus axiosStatus,T t){
        return getInstance(axiosStatus, t);
    }

    /*
   失败的方法
    */
    public static <T> AxiosResult<T> error(T t){
        return getInstance(AxiosStatus.ERROR, t);
    }

    // 给对象赋值
    private static <T> AxiosResult<T> getInstance(AxiosStatus axiosStatus, T t){
        return new AxiosResult<T>(axiosStatus, t);
    }



}
