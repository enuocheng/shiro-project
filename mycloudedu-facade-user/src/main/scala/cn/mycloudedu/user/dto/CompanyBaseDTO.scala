package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/8
  * Time 下午2:59
  */
class CompanyBaseDTO{
  @BeanProperty var id: Int = 0//公司id
  @BeanProperty var district: String = ""
  @BeanProperty var city: String = ""
  @BeanProperty var province: String = ""
  @BeanProperty var name: String = ""
  @BeanProperty var logo: String = ""
  @BeanProperty var stage: Int = 0
  @BeanProperty var scale: Int = 0
  @BeanProperty var industryTag: String = ""
  @BeanProperty var industryName: String = ""
}
