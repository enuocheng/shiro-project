package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/14
  * Time 上午11:40
  */
class College {
  @BeanProperty var id: Integer = null
  @BeanProperty var name: String = null
  @BeanProperty var level: String = null
  @BeanProperty var province: String = null
  @BeanProperty var city: String = null
  @BeanProperty var remark: String = null
  @BeanProperty var department: String = null
  @BeanProperty var logo: String = null
}
