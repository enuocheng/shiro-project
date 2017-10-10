package cn.mycloudedu.sms.service

/**
  * Created by e诺
  * on 2017/4/23
  * Time 上午9:37
  */
trait SmsService {
  /**
    * 生产手机验证码
    *
    * @param mobile     手机
    * @param templateId 模板ID
    */
  @throws(classOf[Exception])
  def generateCode(mobile: String, templateId: String)

  /**
    * 校验手机验证码
    *
    * @param mobile      手机
    * @param code        验证码
    * @param templatedId 模板ID
    */
  def validateCode(mobile: String, templatedId: String, code: String): Boolean
}
