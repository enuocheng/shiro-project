package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/13
  * Time 下午5:11
  */
class Area {
  @BeanProperty var id: Int = 0
  @BeanProperty var name: String = ""
  @BeanProperty var `type`: Byte = 0
  @BeanProperty var parentId: Int = 0
}
