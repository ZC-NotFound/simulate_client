package com.tydic.ares.utils;

import java.util.Calendar;

/**
 * 用来规范鉴权参数有效时间
 *
 * @author Ares
 * @date 2018/1/2 15:29
 */
public enum Time
{
    //一年有多少月
    YEARHASMONTH(12),
    //当前月有多少天
    MONTHHASDAY(Calendar.getInstance().getActualMaximum(Calendar.DATE)),
    //一天有多少小时
    DAYHASHOUR(24),
    //一小时有多少分钟
    HOURHASMINUTE(60),
    //一分钟有多少秒
    MINUTEHASSECOND(60);

    // 定义私有变量
    private int number;

    // 构造函数，枚举类型只能为私有
    Time(int number)
    {
        this.number = number;
    }

    //提供公共方法获取枚举值
    public int value()
    {
        return number;
    }
}
