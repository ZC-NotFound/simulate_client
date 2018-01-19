package com.tydic.ares.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @author Ares
 * @date 2018/1/19 13:53
 */

public class ParseJsonUtil
{
    /**
     * 解析对应路径的json文件并返回一个字符串
     *
     * @return
     */
    public static String parseJson(String path)
    {
        Resource resource = new ClassPathResource(path);
        BufferedReader bufferedReader = null;
        String jsonStr = new String();
        try
        {
            bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String readerStr = null;
            while(null != (readerStr = bufferedReader.readLine()))
            {
                jsonStr = jsonStr + readerStr;
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (bufferedReader != null)
            {
                try
                {
                    bufferedReader.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return jsonStr;
    }
}
