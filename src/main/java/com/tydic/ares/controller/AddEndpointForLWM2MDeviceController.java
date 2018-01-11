package com.tydic.ares.controller;


import com.tydic.ares.entity.AddEndpointForLWM2MDeviceRequest;
import com.tydic.ares.entity.AddEndpointForLWM2MDeviceResponse;
import com.tydic.ares.entity.AdditionalParams;
import com.tydic.ares.intfce.AddEndpointForLWM2MDeviceService;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarException;

/**
 * @author Ares
 * @date 2018/1/2 9:47
 */

@RestController
@RequestMapping(value = "/m2m")
public class AddEndpointForLWM2MDeviceController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AddEndpointForLWM2MDeviceService addEndpointForLWM2MDeviceService;

    @RequestMapping(value = "/endpoints", method = RequestMethod.POST)
    public AddEndpointForLWM2MDeviceResponse addEndpointForLWM2MDevice(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String parameters)
    {
        AddEndpointForLWM2MDeviceRequest addEndpointForLWM2MDeviceRequest = new AddEndpointForLWM2MDeviceRequest();
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

            logger.info("------开始获取参数，参数为:" + parameters);

            JSONObject jsonObject = JSONObject.fromObject(parameters);
            String serialNumber = jsonObject.getString("serialNumber");
            logger.info("serialNumber:" + serialNumber);
            addEndpointForLWM2MDeviceRequest.setSerialNumber(serialNumber);

            String identifier = jsonObject.getString("identifier");
            logger.info("identifier:" + identifier);
            addEndpointForLWM2MDeviceRequest.setIdentifier(identifier);

            String address = jsonObject.getString("address");
            logger.info("address:" + address);
            addEndpointForLWM2MDeviceRequest.setAddress(address);

            String protocol = jsonObject.getString("protocol");
            logger.info("protocol:" + protocol);
            addEndpointForLWM2MDeviceRequest.setProtocol(protocol);

            String groupName = jsonObject.getString("groupName");
            logger.info("groupName:" + groupName);
            addEndpointForLWM2MDeviceRequest.setGroupName(groupName);

          /*  JSONObject additionalParamsJson = JSONObject.fromObject(jsonObject.getString("additionalParams"));
            AdditionalParams additionalParams = new AdditionalParams();
            additionalParams.setPsk(additionalParamsJson.getString("psk"));
            additionalParams.setPskIdentity(additionalParamsJson.getString("pskIdentity"));*/
            //下面的更细致
            String additionalParamsStr = jsonObject.getString("additionalParams");
            logger.info("additionalParamsStr:" + additionalParamsStr);
            JSONObject additionalParamsObject = JSONObject.fromObject(additionalParamsStr);
            String psk = additionalParamsObject.getString("psk");
            logger.info("psk:" + psk);
            AdditionalParams additionalParams = new AdditionalParams();
            additionalParams.setPsk(psk);
            String pskIdentity = additionalParamsObject.getString("pskIdentity");
            logger.info("pskIdentity:" + pskIdentity);
            additionalParams.setPsk(pskIdentity);
            addEndpointForLWM2MDeviceRequest.setAdditionalParams(additionalParams);

            logger.info("------获取消息结束-----");
        } catch (JSONException e)
        {
            throw new RuntimeException("字符串转json出错");
        } catch (Exception e)
        {
            throw new RuntimeException("出错了哈哈哈");
        }
        AddEndpointForLWM2MDeviceResponse addEndpointForLWM2MDeviceResponse = addEndpointForLWM2MDeviceService.addEndpointForLWM2MDevice(addEndpointForLWM2MDeviceRequest);
        return addEndpointForLWM2MDeviceResponse;
    }
}
