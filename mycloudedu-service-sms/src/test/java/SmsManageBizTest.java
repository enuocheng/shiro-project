import cn.mycloudedu.framework.core.utils.DateUtil;
import cn.mycloudedu.sms.biz.SendCodeBiz;
import cn.mycloudedu.sms.biz.ValidateCodeBiz;
import cn.mycloudedu.sms.conf.SmsConfig;
import cn.mycloudedu.sms.dto.CacheValidateCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by e诺
 * on 2017/4/11
 * Time 下午12:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-sms.xml"})
public class SmsManageBizTest {
    @Autowired
    private SendCodeBiz smsManageBiz;
    @Autowired
    private SmsConfig smsConfig;
    @Autowired
    private ValidateCodeBiz validateCodeBiz;

    @Test
    public void sendValidateCodeTest() throws Exception {
        String mobile = "13732256763";
        String templateId=smsConfig.getSmsTemplateCodeModify();
        String code="888888";
        smsManageBiz.sendValidateCode(mobile, templateId, code);
    }

    @Test
    public void saveValidateCodeTest() {
        String mobile = "13732256763";
        String templateId=smsConfig.getSmsTemplateCodeModify();
        CacheValidateCode cacheValidateCode = new CacheValidateCode();
        cacheValidateCode.setCode("123456");
        cacheValidateCode.setCreateTime((int)DateUtil.getCurrentUnixTime());
        cacheValidateCode.setMobile(mobile);
        validateCodeBiz.saveValidateCode(mobile, templateId, cacheValidateCode);
    }
}
