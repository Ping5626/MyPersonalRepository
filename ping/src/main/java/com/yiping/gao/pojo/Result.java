package com.yiping.gao.pojo;

import lombok.Data;

/**
 * @Author: 高一平
 * @Date: 2019/9/2 9:34
 * @Description: 通用返回结果
 **/
@Data
public class Result {
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object result;
}
