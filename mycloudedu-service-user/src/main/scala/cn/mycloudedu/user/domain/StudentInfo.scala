package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/14
  * Time 下午1:58
  */
class StudentInfo {
  @BeanProperty var id: Integer = null
  @BeanProperty var name: String = null
  @BeanProperty var number: String = null
  @BeanProperty var departmentId: Integer = null
  @BeanProperty var classId: Integer = null
  @BeanProperty var userId: Integer = null
  @BeanProperty var grade: Integer = null
  @BeanProperty var verified: Integer = null
  @BeanProperty var createTime: Long = 0
  @BeanProperty var verifiedTime: Long = 0
  @BeanProperty var collegeId: Integer = null
  @BeanProperty var teacherId: Integer = null
  @BeanProperty var departmentName: String = null
  @BeanProperty var collegeName: String = null
}
