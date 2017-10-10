package cn.mycloudedu.sms.exception

import cn.mycloudedu.framework.core.exception.ErrorCode

/**
  * Created by e诺
  * on 2017/4/23
  * Time 上午9:26
  */
class SmsErrorCode(var code: Int, var message: String) extends ErrorCode {
  override def getCode = code

  override def getMessage = message
}

object SmsErrorCode extends Enumeration {
  val VALIDATE_CODE_RATE = Value(12001, "手机验证太频繁")
  val VALIDATE_CODE_TIMEOUT = Value(12002, "验证码过期")
  val VALIDATE_CODE_MISMARCH = Value(12003, "验证码校验失败")
  val VALIDATE_SEND_ERROR = Value(12004, "验证码发送失败")

  def apply(value: SmsErrorCode.Value): SmsErrorCode = new SmsErrorCode(value.id, value.toString)
}

