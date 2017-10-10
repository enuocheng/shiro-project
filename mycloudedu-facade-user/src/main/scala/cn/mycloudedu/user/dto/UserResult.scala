package cn.mycloudedu.user.dto

import cn.mycloudedu.user.domain.UserBase

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/3/31
  * Time 上午9:52
  */
class UserResult extends UserBase with Serializable {
  @BeanProperty var token: String = ""
  @BeanProperty var verified: Boolean = false
  @BeanProperty var collegeName: String = ""
  @BeanProperty var realname: String = ""
}
