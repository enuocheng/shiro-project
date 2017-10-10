package cn.mycloudedu.user.exception

import cn.mycloudedu.framework.core.exception.ErrorCode

/**
  * Created by e诺
  * on 2017/5/4
  * Time 下午3:55
  */
class ResumeErrorCode (var code: Int, var message: String) extends ErrorCode {
  override def getCode = code

  override def getMessage = message
}

object ResumeErrorCode extends Enumeration {
  val UNKNOWN_ACCOUNT_ERROR = Value(80001, "账户不存在")
  val CHAR_LENGTH_ERROR = Value(80002, "个人优势字数在4-60字")
  val EXCEPT_POSITION_ERROR = Value(80003, "期望职位不能超过3个")
  val EXCEPT_ADDRESS_ERROR = Value(80004, "期望地点不能超过3个")

  def apply(value: ResumeErrorCode.Value): ResumeErrorCode = new ResumeErrorCode(value.id, value.toString)
}
