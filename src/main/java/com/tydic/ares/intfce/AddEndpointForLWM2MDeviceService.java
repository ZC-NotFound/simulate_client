package com.tydic.ares.intfce;

import com.tydic.ares.entity.AddEndpointForLWM2MDeviceRequest;
import com.tydic.ares.entity.AddEndpointForLWM2MDeviceResponse;

/**
 * @author Ares
 * @date 2018/1/2 16:28
 */

public interface AddEndpointForLWM2MDeviceService
{
    /**
     * 模拟服务器
     *
     * @param addEndpointForLWM2MDeviceRequest
     *
     * @return
     */
    AddEndpointForLWM2MDeviceResponse addEndpointForLWM2MDevice(AddEndpointForLWM2MDeviceRequest addEndpointForLWM2MDeviceRequest);

}
