package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/15
  * Time 下午5:29
  */
class ResumeEducationDTO extends Serializable{
  @BeanProperty var id: Integer = null//教育经历id
  @BeanProperty var name: String = null//学校名称
  @BeanProperty var startTime: Long = 0//开始时间
  @BeanProperty var endTime: Long = 0//结束时间
  @BeanProperty var profession: String = null//专业
  @BeanProperty var education: Integer = null//学历
  @BeanProperty var major: String = null//主修课程
}
