package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/16
  * Time 下午3:36
  */
class ResumePreviewDTO extends Serializable{
  @BeanProperty var avatar: String = null
  @BeanProperty var name: String = null
  @BeanProperty var sex: Integer = null
  @BeanProperty var birthday: Long = 0
  @BeanProperty var education: Integer = null
  @BeanProperty var mobile: String = null
  @BeanProperty var email: String = null
  @BeanProperty var provinceName: String = null
  @BeanProperty var cityName: String = null
  @BeanProperty var advantage: String = null
  @BeanProperty var sampleName: String = null
  @BeanProperty var sampleFileUrl: String = null
  @BeanProperty var sampleDescription: String = null
}
