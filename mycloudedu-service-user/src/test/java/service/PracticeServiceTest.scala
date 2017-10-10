package service

import cn.mycloudedu.framework.core.result.PageOrder
import cn.mycloudedu.framework.core.utils.JsonBinder
import cn.mycloudedu.user.param.{ReplyCommentParam, WriteCommentParam, WriteLogParam}
import cn.mycloudedu.user.service.PracticeService
import org.apache.log4j.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by e诺
  * on 2017/4/17
  * Time 下午3:16
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("/spring-context.xml"))
class PracticeServiceTest {
  private val log: Logger = Logger.getLogger(this.getClass)
  @Autowired private val practiceService: PracticeService = null

  @Test def getPracticePlanList: Unit = {
    val pageOrder: PageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(10)
    log.info(JsonBinder.toNormalJson(practiceService.getPracticePlanList(1, pageOrder)))
  }

  @Test def getEditLogPlanList: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.getEditLogPlanList(1)))
  }

  @Test def getPracticePlanDetails: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.getPracticePlanDetails(7, 54)))
  }

  @Test def writeLogTest: Unit = {
    val param = new WriteLogParam
    param.setContent("哈哈,我的测试内容!!!!")
    param.setProjectId(1)
    param.setStatus(1)
    param.setTitle("傻逼了吧")

    log.info(JsonBinder.toNormalJson(practiceService.writeLog(1, param, true)))
  }

  @Test def getDraftsLogListTest: Unit = {
    val pageOrder: PageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(10)
    log.info(JsonBinder.toNormalJson(practiceService.getDraftsLogList(1, pageOrder)))
  }

  @Test def getMyLogListTest: Unit = {
    val pageOrder: PageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(10)
    log.info(JsonBinder.toNormalJson(practiceService.getMyLogList(1, pageOrder)))
  }

  @Test def getEditLogTest: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.getEditLog(39)))
  }

  @Test def getLogDetailsTest: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.getLogDetails(1, 1)))
  }

  @Test def getLogCommentTest: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.getLogComment(1)))
  }

  @Test def writeCommentTest: Unit = {
    val param = new WriteCommentParam
    param.setContent("这是写评论,我写些什么好呢?")
    param.setDailyId(3)
    practiceService.writeComment(1, param)
  }

  @Test def replyCommentTest: Unit = {
    val param = new ReplyCommentParam
    param.setContent("这是写评论,我写些什么好呢?")
    param.setDailyId(3)
    param.setParentId(37)
    param.setToUserId(7)
    practiceService.replyComment(1, param)
  }

  @Test def deleteCommentTest: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.deleteComment(37)))
  }

  @Test def intEqualsTest: Unit = {
    log.info(JsonBinder.toNormalJson(practiceService.isSelfComment(2, 10)))
  }
}
