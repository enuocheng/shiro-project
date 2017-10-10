package cn.mycloudedu.user.dto

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/18
  * Time 下午4:46
  */
class MyLogDTO extends Serializable{
  @BeanProperty var id: Int = 0
  @BeanProperty var publishTime: Long = 0
  @BeanProperty var title: String = ""
  @BeanProperty var content: String = ""
  @BeanProperty var images: String = ""
  @BeanProperty var likes: Int = 0
  @BeanProperty var comments: Int = 0
}
