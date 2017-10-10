package cn.mycloudedu.framework.core.exception


/**
  * Created by e诺
  * on 2017/4/21
  * Time 下午5:03
  */
class BusinessException(val errorCode: ErrorCode) extends RuntimeException with Serializable {
  private val code: Int = errorCode.getCode
  private val message: String = errorCode.getMessage
  private var data: AnyRef = null



  def this(errorCode: ErrorCode, obj: AnyRef) {
    this(errorCode)
    this.data = obj
  }

  def getCode = code

  override def getMessage = message

  def getData: AnyRef = data
}
