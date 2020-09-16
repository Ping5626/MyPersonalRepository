package yiping.gao.common.enums;

/**
 * @Author: 高一平
 * @Date: 2019/12/2 14:53
 * @Description:
 **/
public enum HttpEnums {
    /**
     * HTTP相关参数
     */
    CONTENT_TYPE("Content-Type"),
    COMMON("application/x-www-form-urlencoded"),
    JSON("application/json"),
    MULTIPART("multipart/form-data"),
    ;

    private String key;
    public String getKey() {
        return key;
    }

    HttpEnums(String key) {
        this.key = key;
    }
}
