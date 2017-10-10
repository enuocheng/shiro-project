package cn.mycloudedu.sms.biz;

import cn.mycloudedu.framework.core.exception.BusinessException;
import cn.mycloudedu.framework.core.exception.SystemErrorCode;
import cn.mycloudedu.framework.core.utils.DateUtil;
import cn.mycloudedu.sms.conf.SmsConfig;
import cn.mycloudedu.sms.constant.SmsConstant;
import cn.mycloudedu.sms.dto.CacheValidateCode;
import cn.mycloudedu.sms.exception.SmsErrorCode;
import com.google.code.ssm.Cache;
import com.google.code.ssm.api.format.SerializationType;
import com.google.code.ssm.providers.CacheException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @author: e诺
 * @Date: 2017/4/11
 */
@Service
public class ValidateCodeBiz {
    private Logger log = Logger.getLogger(ValidateCodeBiz.class);
    @Autowired
    private Cache cache;
    @Autowired
    private SmsConfig smsConfig;

    public void saveValidateCode(String mobile, String templateId, CacheValidateCode validateCode) {
        String key = getValidateCodeCacheKey(mobile, templateId);
        try {
            CacheValidateCode validateCodeCheck = this.getValidateCode(key);
            if (validateCodeCheck != null) {
                if (checkSendFrequent(validateCodeCheck)) {
                    throw new BusinessException(SmsErrorCode.apply(SmsErrorCode.VALIDATE_CODE_RATE()));
                }
            }
            cache.set(key, smsConfig.getValidateCodeAging() * 60, validateCode, SerializationType.JAVA);
        } catch (TimeoutException e) {
            log.error("缓存超时" + e.getMessage());
            throw new BusinessException(SystemErrorCode.apply(SystemErrorCode.CACHED_SERVICE_ERROR()));
        } catch (CacheException e) {
            log.error("缓存错误" + e.getMessage());
            throw new BusinessException(SystemErrorCode.apply(SystemErrorCode.CACHED_SERVICE_ERROR()));
        }
    }

    private boolean checkSendFrequent(CacheValidateCode validateCode) {
        if (validateCode == null) {
            return true;
        }
        int newDate = (int) DateUtil.getCurrentUnixTime();
        return (newDate - validateCode.getCreateTime() < SmsConstant.SEND_INTERVAL);
    }

    private String getValidateCodeCacheKey(String mobile, String templateId) {
        return mobile + templateId;
    }

    public CacheValidateCode getValidateCode(String mobile, String templateId) {
        String key = getValidateCodeCacheKey(mobile, templateId);
        CacheValidateCode validateCode = null;
        try {
            validateCode = cache.get(key, SerializationType.JAVA);
        } catch (TimeoutException e) {
            log.error("缓存超时" + e.getMessage());
            throw new BusinessException(SystemErrorCode.apply(SystemErrorCode.CACHED_SERVICE_ERROR()));
        } catch (CacheException e) {
            throw new BusinessException(SystemErrorCode.apply(SystemErrorCode.CACHED_SERVICE_ERROR()));
        }

        return validateCode;
    }

    public void deleteValidateCode(String mobile, String templateId) {
        String key = getValidateCodeCacheKey(mobile, templateId);
        try {
            cache.delete(key);
        } catch (TimeoutException e) {
            log.error("缓存超时" + e.getMessage());
        } catch (CacheException e) {
            log.error("缓存错误" + e.getMessage());
        }
    }

    public CacheValidateCode getValidateCode(String key) {
        CacheValidateCode validateCode = null;
        try {
            validateCode = cache.get(key, SerializationType.JAVA);
        } catch (TimeoutException e) {
            log.error("缓存超时" + e.getMessage());
        } catch (CacheException e) {
            log.error("缓存错误" + e.getMessage());
        }
        return validateCode;
    }

    public boolean validateCode(CacheValidateCode validateCode, String userCode) {
        boolean isCheck = false;
        if (validateCode == null || userCode == null) {
            throw new BusinessException(SmsErrorCode.apply(SmsErrorCode.VALIDATE_CODE_MISMARCH()));
        }
        int nowDate = (int) DateUtil.getCurrentUnixTime();
        if (nowDate - validateCode.getCreateTime() > smsConfig.getValidateCodeAging() * 60) {
            isCheck = false;
            throw new BusinessException(SmsErrorCode.apply(SmsErrorCode.VALIDATE_CODE_TIMEOUT()));
        }
        if (!(userCode.trim()).equals(validateCode.getCode().trim())) {
            isCheck = false;
            throw new BusinessException(SmsErrorCode.apply(SmsErrorCode.VALIDATE_CODE_MISMARCH()));
        }
        isCheck = true;
        return isCheck;
    }
}
