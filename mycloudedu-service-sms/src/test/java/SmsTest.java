import cn.mycloudedu.framework.core.utils.JsonBinder;
import cn.mycloudedu.sms.conf.SmsConfig;
import cn.mycloudedu.sms.service.SmsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by e诺
 * on 2017/4/11
 * Time 上午11:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-sms.xml"})
public class SmsTest {
    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private SmsService smsService;
    @Autowired
    private SmsConfig smsConfig;


    @Test
    public void getValidateCodeTest() throws Exception {
//        String mobile = "18005717166";
        String mobile = "13732256763";
        String templateId=smsConfig.getSmsTemplateCodeModify();
        smsService.generateCode(mobile,templateId);
    }

    @Test
    public void validateCodeTest() {
        String mobile = "15655283092";
        String templateId=smsConfig.getSmsTemplateCodeModify();
        String code="211534";
        boolean result = smsService.validateCode(mobile, templateId, code);
        log.info(JsonBinder.toNormalJson(result));
    }
}
