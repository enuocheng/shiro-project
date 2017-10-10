package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/10
  * Time 上午9:19
  */
class ResumeExperienceDTO extends Serializable{
  @BeanProperty var id: Integer = null
  @BeanProperty var name: String = null
  @BeanProperty var position: String = null
  @BeanProperty var description: String = null
  @BeanProperty var status:Integer=null//1-实习经历 2-项目经历
  @BeanProperty var startTime:Long=0//1-实习经历 2-项目经历
  @BeanProperty var endTime:Long=0//1-实习经历 2-项目经历
}
