package com.tydic.ares.controller;

import com.tydic.ares.constant.ContentType;
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
            logger.info("------开始打印消息头信息------");

            String contentType = request.getHeader("Content-Type");
            logger.info("Content-Type:" + contentType);

            String accept = request.getHeader("Accept");
            logger.info("Accept:" + accept);

            String authorization = request.getHeader("Authorization");
            logger.info("Authorization:" + authorization);

            logger.info("------打印消息头信息结束------");

            //当报文为application/json时参数从parameters中获取，当报文为application/x-www-form-urlencoded时参数从request中获取
            logger.info("------开始打印请求报文------");

            if (ContentType.JSON.value().equals(contentType))
            {
                logger.info("请求报文:" + parameters);
            }
            else if (ContentType.FORM.value().equals(contentType))
            {
                logger.info("请求报文:" + JSONObject.fromObject(request.getParameterMap()).toString());
            }

            logger.info("------打印请求报文结束------");
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            throw new RuntimeException("程序发生不可知的错误");
        }
        String success = "OPERATE SUCCESS";
        return success;
    }
}
