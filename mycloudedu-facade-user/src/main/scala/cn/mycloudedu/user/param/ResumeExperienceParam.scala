package cn.mycloudedu.user.param

import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/10
  * Time 上午8:48
  */
class ResumeExperienceParam extends Serializable{
  @NotNull(message = "name:单位／项目名称不能为空")
  @BeanProperty var name: String = null
  @NotNull(message = "position:岗位名称／项目职责不能为空")
  @BeanProperty var position: String = null
  @NotNull(message = "description:描述不能为空")
  @BeanProperty var description: String = null
  @NotNull(message = "startTime:实习开始时间不能为空")
  @BeanProperty var startTime:Long=0
  @NotNull(message = "endTime:实习结束时间不能为空")
  @BeanProperty var endTime:Long=0
}
