package cn.mycloudedu.framework.core.result

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/23
  * Time 上午8:57
  */
class TotalResult {
  @BeanProperty var code: Int = 20000
  @BeanProperty var message: String = "success"
  @BeanProperty var data: Any = null

  def this(data: Any) {
    this()
    this.data = data
  }
}

object TotalResult {
  def newInstance: TotalResult = {
    new TotalResult
  }

  def newInstance(data: Any): TotalResult = {
    new TotalResult(data)
  }
}
