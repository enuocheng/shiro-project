package cn.mycloudedu.framework.core.exception

/**
  * Created by e诺
  * on 2017/4/21
  * Time 下午3:43
  */
trait ErrorCode {
  def getCode: Int

  def getMessage: String
}
