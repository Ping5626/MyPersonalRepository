package com.yiping.gao.common.utils.encrypt;

/**
 * FileName: HexSystemUtil
 * Author: 高一平
 * Date: 2018/3/20 11:55
 * Description: 进制转换
 */

public class HexSystemUtils {

    /**
     * 十进制数转换为十六进制
     * @param num 十进制数
     * @return 十六进制数
     */
    public String decimalToHexadecimal(Integer num){
        return Integer.toHexString(num).toUpperCase();
    }

}
