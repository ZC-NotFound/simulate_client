package com.tydic.ares.controller;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Ares
 * @date 2018/1/11 14:38
 */

@RestController
@RequestMapping(value = "/m2m")
public class GetController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param request
     * @param response
     * @param parameters
     *
     * @return
     */
    @RequestMapping(value = "/common/get", method = RequestMethod.GET)
    public String commonGet(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String parameters)
    {
        try
        {
            logger.info("------开始打印GET消息头信息------");

            String contentType = request.getHeader("Content-Type");
            logger.info("Content-Type:" + contentType);

            String accept = request.getHeader("Accept");
            logger.info("Accept:" + accept);

            String authorization = request.getHeader("Authorization");
            logger.info("Authorization:" + authorization);

            String appKey = request.getHeader("appKey");
            logger.info("appKey:" + appKey);

            logger.info("------打印GET消息头信息结束------");

            //当报文为application/json时参数从parameters中获取，当报文为application/x-www-form-urlencoded时参数从request中获取
            logger.info("------开始打印GET请求报文------");

            logger.info("请求路径:" + request.getServletPath());
            logger.info("url中?后请求参数:" + JSONObject.fromObject(request.getParameterMap()).toString());
            logger.info("消息体中请求参数:" + parameters);

            logger.info("------打印GET请求报文结束------");
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            throw new RuntimeException("程序发生不可知的错误");
        }
        Map<String, String> responseMap = new HashMap<String, String>();
        responseMap.put("msg", "OPERATE SUCCESS");
        return JSONObject.fromObject(responseMap).toString();
    }

    /**
     *
     * @param request
     * @param response
     * @param parameters
     * @return
     */
    @RequestMapping(value = "/common/get/{param}", method = RequestMethod.GET)
    public String commonGetWithParam(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String parameters)
    {
        try
        {
            logger.info("------开始打印带动态参数的GET消息头信息------");

            String contentType = request.getHeader("Content-Type");
            logger.info("Content-Type:" + contentType);

            String accept = request.getHeader("Accept");
            logger.info("Accept:" + accept);

            String authorization = request.getHeader("Authorization");
            logger.info("Authorization:" + authorization);

            String appKey = request.getHeader("appKey");
            logger.info("appKey:" + appKey);

            logger.info("------打印带动态参数的GET消息头信息结束------");

            //当报文为application/json时参数从parameters中获取，当报文为application/x-www-form-urlencoded时参数从request中获取
            logger.info("------开始打印带动态参数的GET请求报文------");

            String params = request.getServletPath().replace("/m2m/common/get/", "").replaceAll("\\{", "").replaceAll("}", ",");
            logger.info("url中/后请求参数:" + params.substring(0, params.length() - 1));
            logger.info("url中?后请求参数:" + JSONObject.fromObject(request.getParameterMap()).toString());
            logger.info("消息体中请求参数:" + parameters);

            logger.info("------打印带动态参数的GET请求报文结束------");
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            throw new RuntimeException("程序发生不可知的错误");
        }
        Map<String, String> responseMap = new HashMap<String, String>();
        responseMap.put("msg", "OPERATE SUCCESS With Param");
        return JSONObject.fromObject(responseMap).toString();
    }
}
