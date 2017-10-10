package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/8
  * Time 下午3:16
  */
class CompanyHomePageDTO extends Serializable {
  @BeanProperty var intro: String = ""
  @BeanProperty var pictures: String = ""
}
