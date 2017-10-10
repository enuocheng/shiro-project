package cn.mycloudedu.user.param

import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/15
  * Time 下午5:57
  */
class ResumeEducationParam {
  @NotNull(message = "name:学校名称不能为空")
  @BeanProperty var name: String = null//学校名称
  @NotNull(message = "starTime:开始时间不能为空")
  @BeanProperty var starTime: Long = 0//开始时间
  @NotNull(message = "endTime:结束时间不能为空")
  @BeanProperty var endTime: Long = 0//结束时间
  @NotNull(message = "profession:专业不能为空")
  @BeanProperty var profession: String = null//专业
  @NotNull(message = "education:学历不能为空")
  @BeanProperty var education: Integer = null//学历
  @NotNull(message = "major:主修课程不能为空")
  @BeanProperty var major: String = null//主修课程
}
