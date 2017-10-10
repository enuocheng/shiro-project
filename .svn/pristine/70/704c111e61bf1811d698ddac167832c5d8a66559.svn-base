import cn.mycloudedu.framework.core.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by e诺
 * on 2017/4/11
 * Time 下午1:12
 */
public class MainTest {
    public static void main(String[] args) {
        String host = "http://sms.market.alicloudapi.com";
        String path = "/singleSendSms";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 626f28b529e84a14b7fc4701fde8f7a9
        headers.put("Authorization", "APPCODE d07b04a5768c49e29681a6d9cb8e680b");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ParamString","{'no':'你个傻逼'}");
        querys.put("RecNum", "15655283092");
        querys.put("SignName", "摩课书院");
        querys.put("TemplateCode", "SMS_34330240");


        try {
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
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
