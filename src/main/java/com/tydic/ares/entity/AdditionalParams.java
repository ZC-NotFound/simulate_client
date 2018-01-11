package com.tydic.ares.entity;

/**
 * @author Ares
 * @date 2018/1/9 11:39
 */
public class AdditionalParams
{
    //这是LWM2M对象所使用的“机密密钥”资源的值:LWM2M安全
    private String psk;

    //这是LWM2M客户机使用的“公共密钥或身份”资源的值
    private String pskIdentity;

    public String getPsk()
    {
        return psk;
    }

    public void setPsk(String psk)
    {
        this.psk = psk;
    }

    public String getPskIdentity()
    {
        return pskIdentity;
    }

    public void setPskIdentity(String pskIdentity)
    {
        this.pskIdentity = pskIdentity;
    }
}
