package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/10
  * Time 上午9:33
  */
class ResumeExperience {
  @BeanProperty var id :Integer= null
  @BeanProperty var startTime :Long= 0L
  @BeanProperty var endTime :Long= 0L
  @BeanProperty var name :String= null
  @BeanProperty var position :String= null
  @BeanProperty var description :String= null
  @BeanProperty var status :Integer= null
  @BeanProperty var userId :Integer= null
  @BeanProperty var resumeId :Integer= null
}
