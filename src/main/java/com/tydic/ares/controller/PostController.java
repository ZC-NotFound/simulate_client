package com.tydic.ares.controller;

import com.tydic.ares.constant.ContentType;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ares
 * @date 2018/1/11 14:36
 */

@RestController
@RequestMapping(value = "/m2m")
public class PostController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @param request
     * @param response
     * @param parameters
     *
     * @return
     */
    @RequestMapping(value = "/common/post", method = RequestMethod.POST)
    public String commonPost(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String parameters)
    {
        try
        {
            logger.info("------开始打印Post消息头信息------");

            String contentType = request.getHeader("Content-Type");
            logger.info("Content-Type:" + contentType);

            String accept = request.getHeader("Accept");
            logger.info("Accept:" + accept);

            String authorization = request.getHeader("Authorization");
            logger.info("Authorization:" + authorization);

            String appKey = request.getHeader("appKey");
            logger.info("appKey:" + appKey);

            logger.info("------打印Post消息头信息结束------");

            //当报文为application/json时参数从parameters中获取，当报文为application/x-www-form-urlencoded时参数从request中获取
            logger.info("------开始打印Post请求报文------");

            logger.info("请求路径:" + request.getServletPath());
            logger.info("url中?后请求报文:" + JSONObject.fromObject(request.getParameterMap()).toString());
            logger.info("消息体中请求报文:" + parameters);
            /*if (contentType.contains(ContentType.JSON.value()))
            {
                logger.info("请求报文:" + parameters);
            }
            else if (contentType.contains(ContentType.FORM.value()))
            {
                logger.info("请求报文:" + JSONObject.fromObject(request.getParameterMap()).toString());
            }
            else
            {
                logger.info("消息头‘" + contentType + "’不符合规范");
            }*/

            logger.info("------打印请求Post报文结束------");
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
     * @param request
     * @param response
     * @param parameters
     *
     * @return
     */
    @RequestMapping(value = "/common/post/{param}", method = RequestMethod.POST)
    public String commonPostWithParam(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String parameters)
    {
        try
        {
            logger.info("------开始打印带动态参数的Post消息头信息------");

            String contentType = request.getHeader("Content-Type");
            logger.info("Content-Type:" + contentType);

            String accept = request.getHeader("Accept");
            logger.info("Accept:" + accept);

            String authorization = request.getHeader("Authorization");
            logger.info("Authorization:" + authorization);

            String appKey = request.getHeader("appKey");
            logger.info("appKey:" + appKey);

            logger.info("------打印带动态参数的Post消息头信息结束------");

            //当报文为application/json时参数从parameters中获取，当报文为application/x-www-form-urlencoded时参数从request中获取
            logger.info("------开始打印带动态参数的Post请求报文------");

            String params = request.getServletPath().replace("/m2m/common/post/{", "").replace("}", ",");
            logger.info("url中/后请求参数:" + params.substring(0, params.length() - 1));
            logger.info("url中?后请求参数:" + JSONObject.fromObject(request.getParameterMap()).toString());
            logger.info("消息体中请求参数:" + parameters);


            logger.info("------打印带动态参数的请求Post报文结束------");
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

    /**
     * @param request
     * @param response
     * @param parameters
     *
     * @return
     */
    @RequestMapping(value = "/common/post/{param}/{paramTwo}", method = RequestMethod.POST)
    public String commonPostWithTwoParam(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String parameters)
    {
        try
        {
            logger.info("------开始打印带两个动态参数的Post消息头信息------");

            String contentType = request.getHeader("Content-Type");
            logger.info("Content-Type:" + contentType);

            String accept = request.getHeader("Accept");
            logger.info("Accept:" + accept);

            String authorization = request.getHeader("Authorization");
            logger.info("Authorization:" + authorization);

            String appKey = request.getHeader("appKey");
            logger.info("appKey:" + appKey);

            logger.info("------打印带两个动态参数的Post消息头信息结束------");

            //当报文为application/json时参数从parameters中获取，当报文为application/x-www-form-urlencoded时参数从request中获取
            logger.info("------开始打印带两个动态参数的Post请求报文------");

            String params = request.getServletPath().replace("/m2m/common/post", "").replaceAll("/", "").replaceAll("\\{", "").replaceAll("}", ",");
            logger.info("url中/后请求参数:" + params.substring(0, params.length() - 1));
            logger.info("url中?后请求参数:" + JSONObject.fromObject(request.getParameterMap()).toString());
            logger.info("消息体中请求参数:" + parameters);


            logger.info("------打印带两个动态参数的请求Post报文结束------");
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            throw new RuntimeException("程序发生不可知的错误");
        }
        Map<String, String> responseMap = new HashMap<String, String>();
        responseMap.put("msg", "OPERATE SUCCESS With Two Param");
        return JSONObject.fromObject(responseMap).toString();
    }
}
