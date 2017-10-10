package cn.mycloudedu.user.dto

import cn.mycloudedu.framework.core.utils.DateUtil

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/17
  * Time 下午2:33
  */
class PracticePlanDTO extends Serializable {
  @BeanProperty var id: Int = 0
  @BeanProperty var name: String = ""
  @BeanProperty var position: String = ""
  @BeanProperty var standard: String = ""
  @BeanProperty var createTime: Long = 0
  @BeanProperty var startTime: Long = 0
  @BeanProperty var endTime: Long = 0
  var status: Integer = 0

  def setStatus(status: Integer) = {
    this.status = status
  }

  def getStatus: Int = {
    val currentTime = DateUtil.getTimeStamp
    if (startTime > currentTime) this.status = 0
    else if (currentTime <= endTime) this.status = 1
    else this.status = 2
    status
  }
}
