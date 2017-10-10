package biz

import cn.mycloudedu.framework.core.result.PageOrder
import cn.mycloudedu.framework.core.utils.JsonBinder
import cn.mycloudedu.user.biz.CollegeDepartmentBiz
import org.apache.log4j.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by e诺
  * on 2017/4/26
  * Time 上午11:14
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("/spring-context.xml"))
class CollegeDepartmentBizTest {
  private val log = Logger.getLogger(this.getClass)

  @Autowired private val collegeDepartmentBiz: CollegeDepartmentBiz = null

  @Test def multiThreadImportTest: Unit = {
    val pageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(20)
    log.info(JsonBinder.toNormalJson(collegeDepartmentBiz.getDataList(pageOrder)))
  }
  @Test def pageCollegeMapIdTest: Unit = {
    val pageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(20)
    log.info(JsonBinder.toNormalJson(collegeDepartmentBiz.pageCollegeMapId(pageOrder)))
  }

}
