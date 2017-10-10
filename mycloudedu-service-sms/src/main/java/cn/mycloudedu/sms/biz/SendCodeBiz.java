package cn.mycloudedu.sms.biz;

import cn.mycloudedu.framework.core.exception.BusinessException;
import cn.mycloudedu.framework.core.utils.HttpUtils;
import cn.mycloudedu.sms.conf.SmsConfig;
import cn.mycloudedu.sms.exception.SmsErrorCode;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: e诺
 * @Date: 2017/4/11
 */
@Service
public class SendCodeBiz {
    private Logger log = Logger.getLogger(SendCodeBiz.class);
    @Autowired
    private SmsConfig smsConfig;

    public void sendValidateCode(String mobile, String templateId, String code) throws Exception {
        String host = smsConfig.getSmsHost();
        String path = smsConfig.getSmsPath();
        String method = smsConfig.getSmsMethod();
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 626f28b529e84a14b7fc4701fde8f7a9
        headers.put("Authorization", smsConfig.getSmsAppcode());
        String paramString = "{\"no\":" + "\"" + code + "\"" + ",\"time\":" + "\"10" + "\"}";
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ParamString", paramString);
        querys.put("RecNum", mobile);
        querys.put("SignName", smsConfig.getSmsSignName());
        querys.put("TemplateCode", templateId);
        /**
         * 重要提示如下:
         * HttpUtils请从
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
         * 下载
         *
         * 相应的依赖请参照
         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
         */
        HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
        //System.out.println(response.toString());
        //获取response的body
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        JSONObject jsonObject = JSONObject.fromObject(result);
        String success = jsonObject.get("success").toString();
        if (success.equals("false")) {
            throw new BusinessException(SmsErrorCode.apply(SmsErrorCode.VALIDATE_SEND_ERROR()), jsonObject.get("message"));
        }
    }
}
