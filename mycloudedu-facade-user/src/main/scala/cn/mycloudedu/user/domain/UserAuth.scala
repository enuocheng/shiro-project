package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/3/31
  * Time 上午10:30
  */
class UserAuth extends UserBase with Serializable{
  @BeanProperty var password: String = ""
}
