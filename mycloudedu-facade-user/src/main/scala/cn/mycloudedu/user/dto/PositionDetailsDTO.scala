package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/8
  * Time 上午9:58
  */
class PositionDetailsDTO extends RecommendPositionDTO{
  @BeanProperty var companyId: Int = 0
  @BeanProperty var tag: String = ""
  @BeanProperty var specialNote: String = ""
  @BeanProperty var industryTag: String = ""
  @BeanProperty var address: String = ""
  @BeanProperty var description: String = ""
  @BeanProperty var scale: Int = 0
}
