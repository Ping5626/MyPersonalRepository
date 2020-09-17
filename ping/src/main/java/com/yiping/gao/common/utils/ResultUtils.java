package com.yiping.gao.common.utils;

import com.yiping.gao.pojo.dto.Result;
import com.yiping.gao.service.AbstractService;

/**
 * @Author: 高一平
 * @Date: 2019/9/2 9:42
 * @Description: 封装返回结果
 **/
public class ResultUtils implements AbstractService {

    /**
     * 封装成功的返回结果
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 封装成功的返回结果
     *
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode("0");
        result.setMsg("请求成功");
        result.setResult(object);
        return result;
    }

}
