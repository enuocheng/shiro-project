package cn.mycloudedu.sms.service;

import cn.mycloudedu.framework.core.utils.DateUtil;
import cn.mycloudedu.framework.core.utils.ValidateCodeUtil;
import cn.mycloudedu.sms.biz.SendCodeBiz;
import cn.mycloudedu.sms.biz.ValidateCodeBiz;
import cn.mycloudedu.sms.constant.SmsConstant;
import cn.mycloudedu.sms.dto.CacheValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: e诺
 * @Date: 2017/4/11
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {
    @Autowired
    private SendCodeBiz smsManageBiz;
    @Autowired
    private ValidateCodeBiz validateCodeBiz;

    @Override
    public void generateCode(String mobile, String templateId) throws Exception {
        String code = ValidateCodeUtil.generateTextCode(ValidateCodeUtil.TYPE_NUM_ONLY, SmsConstant.VALIDATE_CODE_LENGHT, null);
        CacheValidateCode validateCode = new CacheValidateCode();
        validateCode.setCode(code);
        validateCode.setCreateTime((int) DateUtil.getCurrentUnixTime());
        validateCode.setMobile(mobile);
        validateCodeBiz.saveValidateCode(mobile, templateId, validateCode);
        smsManageBiz.sendValidateCode(mobile, templateId, code);
    }

    @Override
    public boolean validateCode(String mobile, String templatedId, String code) {
        CacheValidateCode validateCode = validateCodeBiz.getValidateCode(mobile, templatedId);
        boolean isCheck = false;
        isCheck = validateCodeBiz.validateCode(validateCode, code);
        validateCodeBiz.deleteValidateCode(mobile, templatedId);
        return isCheck;
    }
}
