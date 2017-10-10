package cn.mycloudedu.user.domain

import cn.mycloudedu.framework.core.annotations.OrderProperty

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/17
  * Time 下午3:40
  */
class Project {
  @BeanProperty var id: Integer = null
  @BeanProperty var name: String = null
  @BeanProperty var collegeId: Integer = null
  @BeanProperty var teacherId: Integer = null
  @OrderProperty @BeanProperty var createTime: Long = 0
  @BeanProperty var endTime: Long = 0
  @BeanProperty var startTime: Long = 0
  @BeanProperty var standard: String = null
}
