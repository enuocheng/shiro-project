package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/4
  * Time 上午11:29
  */
class SchoolAuthenticateSuccessDTO extends Serializable {
  @BeanProperty var name: String = ""
  @BeanProperty var number: String = ""
  @BeanProperty var collegeName: String = ""
  @BeanProperty var grade: Int = 0
}
