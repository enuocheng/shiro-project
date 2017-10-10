package cn.mycloudedu.sms.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/23
  * Time 上午9:25
  */
class CacheValidateCode extends Serializable{
  @BeanProperty var mobile: String = null
  @BeanProperty var createTime: Int = 0
  @BeanProperty var code: String = null
}
