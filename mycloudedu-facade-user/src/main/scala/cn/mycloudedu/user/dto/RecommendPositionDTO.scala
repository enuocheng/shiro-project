package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午3:30
  */
class RecommendPositionDTO extends Serializable {
  @BeanProperty var id: Int = 0
  @BeanProperty var title: String = ""
  @BeanProperty var degree: Int = 0
  @BeanProperty var minSalary: Int = 0
  @BeanProperty var maxSalary: Int = 0
  @BeanProperty var updateTime: Long = 0
  @BeanProperty var district: String = ""
  @BeanProperty var city: String = ""
  @BeanProperty var name: String = ""
  @BeanProperty var logo: String = ""
  @BeanProperty var stage: Int = 0
}
