package service

import cn.mycloudedu.framework.core.result.PageOrder
import cn.mycloudedu.user.service.CollegeDepartmentService
import org.apache.log4j.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
  * Created by e诺
  * on 2017/4/25
  * Time 上午9:50
  */
@RunWith(classOf[SpringJUnit4ClassRunner])
@ContextConfiguration(Array("/spring-context.xml"))
class CollegeDepartmentTest {
  private val log = Logger.getLogger(this.getClass)
  @Autowired val collegeDepartmentService: CollegeDepartmentService = null

  @Test def importCollegeDepartmentTest: Unit = {
    val pageOrder = new PageOrder
    pageOrder.setCurrent(1)
    pageOrder.setPageSize(50)
    collegeDepartmentService.importCollegeDepartment("/Users/cmz/college.json", pageOrder)
  }
}
