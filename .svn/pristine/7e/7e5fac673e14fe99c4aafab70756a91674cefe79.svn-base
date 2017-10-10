package cn.mycloudedu.sms.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
* @Description:
* @author: e诺
* @Date: 2017/4/11
*/
@Component
public class SmsConfig implements Serializable{
    @Value("${sms.host}")
    private String smsHost="";
    @Value("${sms.path}")
    private String smsPath="";
    @Value("${sms.method}")
    private String smsMethod="";
    @Value("${sms.appcode}")
    private String smsAppcode="";
    @Value("${sms.signName}")
    private String smsSignName="";
    @Value("${sms.templateCode.register}")
    private String smsTemplateCodeRegister="";
    @Value("${sms.templateCode.bind}")
    private String smsTemplateCodeBind="";
    @Value("${sms.templateCode.forget}")
    private String smsTemplateCodeForget="";
    @Value("${validate.code.aging}")
    private int validateCodeAging;
    @Value("${sms.templateCode.modify}")
    private String smsTemplateCodeModify = "";

    public String getSmsHost() {
        return smsHost;
    }

    public String getSmsPath() {
        return smsPath;
    }

    public String getSmsMethod() {
        return smsMethod;
    }

    public String getSmsAppcode() {
        return smsAppcode;
    }

    public String getSmsSignName() {
        return smsSignName;
    }

    public String getSmsTemplateCodeRegister() {
        return smsTemplateCodeRegister;
    }

    public String getSmsTemplateCodeBind() {
        return smsTemplateCodeBind;
    }

    public String getSmsTemplateCodeForget() {
        return smsTemplateCodeForget;
    }

    public int getValidateCodeAging() {
        return validateCodeAging;
    }

    public String getSmsTemplateCodeModify() {
        return smsTemplateCodeModify;
    }
}
