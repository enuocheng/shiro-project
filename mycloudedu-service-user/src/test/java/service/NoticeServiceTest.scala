package service

import cn.mycloudedu.framework.core.result.PageOrder
import cn.mycloudedu.framework.core.utils.JsonBinder
import cn.mycloudedu.user.service.NoticeService
import org.apache.log4j.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午2:45
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("/spring-context.xml"))
class NoticeServiceTest {
  private val log = Logger.getLogger(this.getClass)
  @Autowired val noticeService: NoticeService = null


  @Test def getRecruitPositionTest: Unit = {
    val pageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(20)
    log.info(JsonBinder.toNormalJson(noticeService.getNoticeList(11, pageOrder)))
  }

  @Test def getNoticeDetailsTest: Unit = {
    log.info(JsonBinder.toNormalJson(noticeService.getNoticeDetails(4)))
  }
}
