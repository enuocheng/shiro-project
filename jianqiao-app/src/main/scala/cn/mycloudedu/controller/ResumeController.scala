package cn.mycloudedu.controller

import cn.mycloudedu.framework.core.result.TotalResult
import cn.mycloudedu.user.service.ResumeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, ResponseBody}

/**
  * Created by e诺
  * on 2017/5/4
  * Time 上午8:52
  */
@Controller
@RequestMapping(Array("resume"))
class ResumeController extends BaseController {
  @Autowired private val resumeService: ResumeService = null

  @RequestMapping(value = Array("get"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getRegisterValidateCode(@RequestParam("mobile") mobile: String): AnyRef = {
    Assert.notNull(mobile, "mobile:手机号不能为空")

    TotalResult.newInstance(true)
  }
}
