package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/12
  * Time 上午10:27
  */
class User {
  @BeanProperty var id: Int = 0
  @BeanProperty var username: String = null
  @BeanProperty var nickname: String = null
  @BeanProperty var password: String = null
  @BeanProperty var sex: Integer = null
  @BeanProperty var email: String = null
  @BeanProperty var mobile: String = null
  @BeanProperty var birthday: Long = 0
  @BeanProperty var createTime: Long = 0
  @BeanProperty var lastLoginTime: Long = 0
  @BeanProperty var locked: Integer = null
  @BeanProperty var emailVerified: Integer = null
  @BeanProperty var mobileVerified: Integer = null
  @BeanProperty var avatar: String = null
  @BeanProperty var salt: String = null
  @BeanProperty var province: Integer = null
  @BeanProperty var city: Integer = null
}
