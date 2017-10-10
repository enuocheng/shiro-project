package cn.mycloudedu.user.exception

import cn.mycloudedu.framework.core.exception.ErrorCode

/**
  * Created by e诺
  * on 2017/4/21
  * Time 下午10:14
  */
class UserErrorCode(var code: Int, var message: String) extends ErrorCode {
  override def getCode = code

  override def getMessage = message
}

object UserErrorCode extends Enumeration {
  val UNKNOWN_ACCOUNT_ERROR = Value(80001, "账户不存在")
  val INCORRECT_PASSWORD_ERROR = Value(80002, "用户密码错误")
  val LOCKED_ACCOUNT_ERROR = Value(80003, "账户被锁")
  val EXCESSIVE_ATTEMPTS_ERROR = Value(80004, "账户尝试失败5次")
  val AUTHENTICATION_ERROR = Value(80005, "账户认证失败")
  val MOBILE_EXISTS_ERROR = Value(80006, "手机号已存在")
  val MOBILE_NOTFOUND_ERROR = Value(80007, "手机不存在")
  val USER_NOTFOUND_ERROR = Value(80008, "用户不存在")
  val USERNAME_REGEX_ERROR = Value(80009, "用户名格式不正确")
  val MOBILE_REGEX_ERROR = Value(80010, "手机格式不正确")
  val SMS_TEMPLATE_ERROR = Value(80011, "手机验证码模板错误")
  val SCHOOL_AUTH_ERROR = Value(80012, "老师未导入您的个人信息，请联系您的老师")
  val SESSION_TIMEOUT_ERROR = Value(80013, "SESSION过期")
  val IS_NOT_SELF_COMMENT = Value(80014, "不是自己的评论,不能删除")
  val EMAIL_REGEX_ERROR = Value(80015, "邮箱格式不正确")
  val MOBILE_SELF_ERROR = Value(80016, "不是自己的手机号")
  val STUDENT_NAME_ERROR = Value(80017, "姓名不匹配")
  val STUDENT_SCHOOL_ERROR = Value(80018, "学校不匹配")
  val STUDENT_NUMBER_ERROR = Value(80019, "学号不匹配")

  def apply(value: UserErrorCode.Value): UserErrorCode = new UserErrorCode(value.id, value.toString)
}