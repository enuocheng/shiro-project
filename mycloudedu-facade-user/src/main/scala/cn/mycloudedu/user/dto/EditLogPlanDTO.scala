package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/3
  * Time 上午10:15
  */
class EditLogPlanDTO extends Serializable{
  @BeanProperty var id: Int = 0
  @BeanProperty var name: String = ""
}
