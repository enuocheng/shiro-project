package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/18
  * Time 下午3:04
  */
class EditLogDTO extends Serializable {
  @BeanProperty var id: Int = 0
  @BeanProperty var projectId: Int = 0
  @BeanProperty var projectName: String = ""
  @BeanProperty var title: String = ""
  @BeanProperty var content: String = ""
  @BeanProperty var scope: Int = 0
  @BeanProperty var images: String = ""
  @BeanProperty var status: Int = 0
}
