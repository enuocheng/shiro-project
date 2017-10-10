package cn.mycloudedu.framework.core.exception

/**
  * Created by e诺
  * on 2017/4/21
  * Time 下午5:37
  */
class BusinessErrorCode(var code: Int, var message: String) extends ErrorCode {
  override def getCode = code

  override def getMessage = message
}

object BusinessErrorCode extends Enumeration {
  val DATE_FORMAT_ERROR = Value(20001, "时间格式错误")
  val PARAM_ERROR = Value(20002, "参数不合法")

  def apply(value: BusinessErrorCode.Value): BusinessErrorCode = new BusinessErrorCode(value.id, value.toString)
}
