package com.tydic.ares.constant;

/**
 * MediaType，即是Internet Media Type，互联网媒体类型；
 * 也叫做MIME类型，在Http协议消息头中，使用Content-Type来表示具体请求中的媒体类型信息。
 *
 * @author Ares
 * @date 2018/1/11 10:35
 */
public enum ContentType
{
    JSON("application/json"),
    FORM("application/x-www-form-urlencoded");

    // 定义私有变量
    private String str;

    // 构造函数，枚举类型只能为私有
    ContentType(String str)
    {
        this.str = str;
    }

    //提供公共方法获取枚举值
    public String value()
    {
        return str;
    }
}
