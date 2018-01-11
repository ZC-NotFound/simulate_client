package com.tydic.ares.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Date;

/**
 * @author Ares
 * @date 2018/1/2 17:04
 */
public class MD5
{

    /**
     * 根据传入的参数生成鉴权参数
     *
     * @param paramOne
     * @param paramTwo
     *
     * @return
     */
    public static String authorityParameter(String paramOne, String paramTwo)
    {

        StringBuilder stringBuilder = new StringBuilder(32);

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest((paramOne + paramTwo + new Date()).getBytes("utf-8"));

            for (byte anArray : array)
            {
                stringBuilder.append(Integer.toHexString((anArray & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
        } catch (Exception e)
        {
            throw new RuntimeException("生成鉴权参数出错");
        }

        return stringBuilder.toString();
    }

}
