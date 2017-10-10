package cn.mycloudedu.user.util;

import cn.mycloudedu.user.config.UserConfig;
import cn.mycloudedu.user.domain.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 乾坤 on 2016/6/3.
 */
@Component
public class PasswordHelper {
    @Autowired
    private UserConfig userConfig;
    private   RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private   String algorighmName= "md5";
    private final int hashIterations = 1;
    public  void encryptPassword(User user){
        String newPassword = new SimpleHash(algorighmName,user.getPassword(),
                ByteSource.Util.bytes(userConfig.getUserSalt()),hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
