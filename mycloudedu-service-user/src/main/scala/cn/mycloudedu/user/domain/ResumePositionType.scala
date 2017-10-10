package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/9
  * Time 下午2:02
  */
class ResumePositionType {
  @BeanProperty var id: Integer = null
  @BeanProperty var resumeId: Integer = null
  @BeanProperty var userId: Integer = null
  @BeanProperty var positionTypeId: Integer = null
  @BeanProperty var createTime: Long = 0L
}
