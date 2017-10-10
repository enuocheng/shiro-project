package cn.mycloudedu.framework.core.exception

/**
  * Created by e诺
  * on 2017/4/21
  * Time 下午5:45
  */
class SystemErrorCode(var code: Int, var message: String) extends ErrorCode {
  override def getCode = code

  override def getMessage = message
}

object SystemErrorCode extends Enumeration {

  val SYSTME_ERROR = Value(10001, "系统错误")
  val DATABASE_ERROE = Value(10002, "数据库出错")
  val NULLPOINTER_ERROR = Value(10003, "空指针异常")
  val ARRAY_INDEXOUTOF_ERROR = Value(10004, "数组越界错误")
  val RUNTIME_ERROR = Value(10005, "系统运行异常")
  val INVALID_SIGN = Value(10006, "无效的参数签名")
  val INVALID_APPKEY = Value(10007, "无效APPKEY")
  val PARAMETER_NOT_PRESENT = Value(10008, "参数不存在")
  val BEAN_VALIDATION_ERROR = Value(10009, "类校验出错")
  val SESSION_TIMEOUT_ERROR = Value(10010, "SESSION过期")
  val VALIDATE_CODEMISMATCH_ERROR = Value(10011, "验证码校验错误")
  val USER_NOTPRIVILEGE_ERROR = Value(10012, "用户没有权限")
  val USER_NOTLOGIN_ERROR = Value(10013, "用户没有登录")
  val CACHED_SERVICE_ERROR = Value(10014, "缓存出错")
  val ORDER_PROPERTY_ERROR = Value(10015, "排序属性错误")
  val ORDER_DIRECTION_ERROR = Value(10016, "排序方向错误")

  def apply(value: SystemErrorCode.Value): SystemErrorCode = new SystemErrorCode(value.id, value.toString)
}
