package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午3:20
  */
class NoticeDTO extends Serializable {
  @BeanProperty var id: Integer = null
  @BeanProperty var title: String = null
  @BeanProperty var createTime: Long = 0
  @BeanProperty var avatar: String = null
  @BeanProperty var name: String = null
}
