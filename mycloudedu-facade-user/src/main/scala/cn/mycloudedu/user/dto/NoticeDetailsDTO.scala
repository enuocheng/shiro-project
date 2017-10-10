package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午4:13
  */
class NoticeDetailsDTO extends Serializable{
  @BeanProperty var id: Integer = null
  @BeanProperty var title: String = null
  @BeanProperty var content: String = null
  @BeanProperty var createTime: Long = 0
  @BeanProperty var avatar: String = null
  @BeanProperty var teacherName: String = null
  @BeanProperty var className: String = null
  @BeanProperty var projectName: String = null
}
