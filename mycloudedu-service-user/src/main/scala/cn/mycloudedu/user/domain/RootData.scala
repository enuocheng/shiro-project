package cn.mycloudedu.user.domain

import java.util.{List => JavaList}

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/25
  * Time 上午9:44
  */
class RootData {
  @BeanProperty var name: String = null
  @BeanProperty var data: JavaList[Data] = null
}
