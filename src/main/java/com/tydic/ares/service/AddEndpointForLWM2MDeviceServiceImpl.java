package com.tydic.ares.service;

import com.tydic.ares.entity.AddEndpointForLWM2MDeviceRequest;
import com.tydic.ares.entity.AddEndpointForLWM2MDeviceResponse;
import com.tydic.ares.intfce.AddEndpointForLWM2MDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Ares
 * @date 2018/1/2 16:28
 */

@Service
public class AddEndpointForLWM2MDeviceServiceImpl implements AddEndpointForLWM2MDeviceService
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 模拟服务器
     *
     * @param simulateClientRequest
     *
     * @return
     */
    @Override
    public AddEndpointForLWM2MDeviceResponse addEndpointForLWM2MDevice(AddEndpointForLWM2MDeviceRequest simulateClientRequest)
    {
        AddEndpointForLWM2MDeviceResponse addEndpointForLWM2MDeviceResponse = new AddEndpointForLWM2MDeviceResponse();

        logger.info("------开始构造返回参数------");

        String msg = "Device Added Successfully";
        logger.info("msg:" + msg);
        addEndpointForLWM2MDeviceResponse.setMsg(msg);

        logger.info("------构造返回参数结束------");

        return addEndpointForLWM2MDeviceResponse;
    }

}
