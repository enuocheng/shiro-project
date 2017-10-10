package cn.mycloudedu.user.dto

import scala.beans.BeanProperty
import java.util.{List => JavaList}

/**
  * Created by e诺
  * on 2017/5/16
  * Time 下午5:11
  */
class JobIntentionDTO extends Serializable {
  @BeanProperty var minSalary: Integer = null
  @BeanProperty var maxSalary: Integer = null
  @BeanProperty var time: Integer = null
  @BeanProperty var property: Integer = null
  @BeanProperty var positionList: JavaList[String] = null
  @BeanProperty var areaList: JavaList[String] = null
}
