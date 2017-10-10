package cn.mycloudedu.controller

import cn.mycloudedu.framework.core.result.{PageOrder, TotalResult}
import cn.mycloudedu.shiro.ShiroUtil
import cn.mycloudedu.user.service.NoticeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, ResponseBody}

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午4:26
  */
@Controller
@RequestMapping(Array("notice"))
class NoticeController {
  @Autowired private val noticeService: NoticeService = null

  /**
    * 获取通告列表
    *
    * @param pageOrder
    * @return
    */
  @RequestMapping(value = Array("list"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getNoticeList(pageOrder: PageOrder): AnyRef = {
    val noticeList = noticeService.getNoticeList(ShiroUtil.getUserId, pageOrder)
    TotalResult.newInstance(noticeList)
  }

  /**
    * 获取通告详情
    *
    * @param noticeId
    * @return
    */
  @RequestMapping(value = Array("details"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getNoticeDetails(@RequestParam("noticeId") noticeId: Int): AnyRef = {
    Assert.notNull(noticeId, "noticeId:通告id不能为空")
    val details = noticeService.getNoticeDetails(noticeId)
    TotalResult.newInstance(details)
  }
}
