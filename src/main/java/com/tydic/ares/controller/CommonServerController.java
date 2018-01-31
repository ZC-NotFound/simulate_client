package com.tydic.ares.controller;

import com.tydic.ares.constant.ContentType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wkguan on 2018/1/11.
 */
@Controller
@RequestMapping(value = "/modify")
public class CommonServerController
{
    private final Logger logger = LoggerFactory.getLogger(CommonServerController.class);

    @RequestMapping(value = "/methodContextType", method = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT})
    public @ResponseBody
    Object methodContextType(HttpServletRequest httpServletRequest)
    {
        System.out.println(httpServletRequest.getQueryString());
        System.out.println(httpServletRequest.getParameterMap());
        try
        {
            //原生的从请求消息体中获取内容，转成字符串，最终可以转成对应的消息格式
            BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String temp;
            while((temp = br.readLine()) != null)
            {
                sb.append(temp);
            }
            br.close();

            System.out.println(sb.toString());
            return JSONObject.fromObject(sb.toString());

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    @RequestMapping(value = "/post/self/{serviceId}")
    public @ResponseBody
    String testModifyPostMethod(HttpServletRequest httpServletRequest, @RequestBody(required = false) String bodyParamters)
    {
        String contentType = httpServletRequest.getHeader("Content-Type");
        logger.info("Content-Type:" + contentType);
        String authorization = httpServletRequest.getHeader("Authorization");
        logger.info("Authorization:" + authorization);
        logger.info("请求方式：" + httpServletRequest.getMethod());

        logger.info("queryString: " + httpServletRequest.getQueryString());
        logger.info("parameterMap: " + httpServletRequest.getParameterMap());
        if (contentType.contains(ContentType.JSON.value()))
        {
            logger.info("请求报文:" + bodyParamters);
        }
        else if (contentType.contains(ContentType.FORM.value()))
        {
            logger.info("请求报文:" + JSONObject.fromObject(httpServletRequest.getParameterMap()).toString());
        }
        else
        {
            logger.info("消息头为‘" + contentType + "’不符合规范");
        }
        Map<String, String> responseMap = new HashMap<String, String>();
        try
        {
            //原生的从请求消息体中获取内容，转成字符串，最终可以转成对应的消息格式
            BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String temp;
            while((temp = br.readLine()) != null)
            {
                sb.append(temp);
            }
            br.close();

            logger.info(sb.toString());

        } catch (IOException e)
        {
            logger.error("", e);
        }
        responseMap.put("msg", "SELF OPERATE SUCCESS, 成功了,测试中文是否乱码");
        responseMap.put("code", "0000");
        return JSONObject.fromObject(responseMap).toString();
    }

    @RequestMapping(value = "/post/hsn/{serviceId}")
    public @ResponseBody
    String testModifyPostHsnMethod(HttpServletRequest httpServletRequest, @RequestBody(required = false) String bodyParamters)
    {
        String contentType = httpServletRequest.getHeader("Content-Type");
        logger.info("Content-Type:" + contentType);
        String authorization = httpServletRequest.getHeader("Authorization");
        logger.info("Authorization:" + authorization);
        logger.info("请求方式：" + httpServletRequest.getMethod());

        logger.info("queryString: " + httpServletRequest.getQueryString());
        logger.info("parameterMap: " + httpServletRequest.getParameterMap());
        if (contentType.contains(ContentType.JSON.value()))
        {
            logger.info("请求报文:" + bodyParamters);
        }
        else if (contentType.contains(ContentType.FORM.value()))
        {
            logger.info("请求报文:" + JSONObject.fromObject(httpServletRequest.getParameterMap()).toString());
        }
        else
        {
            logger.info("消息头为‘" + contentType + "’不符合规范");
        }
        try
        {
            //原生的从请求消息体中获取内容，转成字符串，最终可以转成对应的消息格式
            BufferedReader br = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String temp;
            while((temp = br.readLine()) != null)
            {
                sb.append(temp);
            }
            br.close();

            logger.info(sb.toString());

        } catch (IOException e)
        {
            logger.error("", e);
        }
        Map<String, String> responseMap = new HashMap<String, String>();
        responseMap.put("msg", "HSN OPERATE SUCCESS");
        responseMap.put("code", "0000");
        return JSONObject.fromObject(responseMap).toString();
    }

    @RequestMapping(value = "/testRespByJsonFile/{interfaceName}")
    public @ResponseBody
    String testRespByJsonFile(HttpServletRequest httpServletRequest, @RequestBody(required = false) String bodyParamters)
    {
        String contentType = httpServletRequest.getHeader("Content-Type");
        logger.info("Content-Type:" + contentType);
        String authorization = httpServletRequest.getHeader("Authorization");
        logger.info("Authorization:" + authorization);
        logger.info("请求方式：" + httpServletRequest.getMethod());

        logger.info("queryString: " + httpServletRequest.getQueryString());
        logger.info("parameterMap: " + httpServletRequest.getParameterMap());
        if (contentType.contains(ContentType.JSON.value()))
        {
            logger.info("请求报文:" + bodyParamters);
        }
        else if (contentType.contains(ContentType.FORM.value()))
        {
            logger.info("请求报文:" + JSONObject.fromObject(httpServletRequest.getParameterMap()).toString());
        }
        else
        {
            logger.info("消息头为‘" + contentType + "’不符合规范");
        }

        File jsonFile = null;
        FileInputStream file = null;
        BufferedReader reader = null;
        InputStreamReader inputFileReader = null;
        String content = "";
        String tempString = null;
        try
        {
            String reqUrl = httpServletRequest.getServletPath();
            if (reqUrl.endsWith("test"))
            {
                jsonFile = ResourceUtils.getFile("classpath:json/test.json");
            }

            file = new FileInputStream(jsonFile);
            inputFileReader = new InputStreamReader(file, "utf-8");
            reader = new BufferedReader(inputFileReader);
            // 一次读入一行，直到读入null为文件结束
            while((tempString = reader.readLine()) != null)
            {
                content += tempString;
            }
            reader.close();
        } catch (FileNotFoundException e)
        {
            logger.error("can not find the file: ", e);
            Map<String, String> responseMap = new HashMap<String, String>();
            responseMap.put("msg", e.getMessage());
            responseMap.put("code", "8888");
            return JSONObject.fromObject(responseMap).toString();
        } catch (IOException e)
        {
            logger.error("IOException : ", e);
            Map<String, String> responseMap = new HashMap<String, String>();
            responseMap.put("msg", e.getMessage());
            responseMap.put("code", "8888");
            return JSONObject.fromObject(responseMap).toString();
        } finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    logger.error("reader close error: ", e);
                }
            }
        }
        return JSONObject.fromObject(content).toString();
    }
}
