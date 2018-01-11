package com.tydic.ares.entity;

/**
 * @author Ares
 * @date 2018/1/2 16:31
 */
public class AddEndpointForLWM2MDeviceRequest
{
    //LWM2M 设备的序列号
    private String serialNumber;

    //它是唯一标识LWM2M设备的名称别名
    private String identifier;

    //这个地址通常是与设备相关的MSISDN
    private String address;

    //LWM2M :为 LWM2M 设备
    private String protocol;

    //该设备将在其中注册IMPACT的groupName
    private String groupName;

    //LWM2M有效载荷的附加参数，普通LWM2M设备可以不必填写。
    private AdditionalParams additionalParams;

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getProtocol()
    {
        return protocol;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public AdditionalParams getAdditionalParams()
    {
        return additionalParams;
    }

    public void setAdditionalParams(AdditionalParams additionalParams)
    {
        this.additionalParams = additionalParams;
    }
}
