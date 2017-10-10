package cn.mycloudedu.user.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/12
  * Time 上午11:07
  */
@Component
class UserConfig {
  @Value("${user.salt}")
  @BeanProperty var userSalt: String = ""
  @Value("${nickname.prefix}")
  @BeanProperty var nicknamePrefix: String = ""
}
