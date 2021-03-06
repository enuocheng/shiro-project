package cn.mycloudedu.user.service

import cn.mycloudedu.framework.core.result.PageOrder
import cn.mycloudedu.user.biz.CollegeDepartmentBiz
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by e诺
  * on 2017/4/25
  * Time 上午9:37
  */
@Service("collegeDepartmentService")
class CollegeDepartmentServiceImpl extends CollegeDepartmentService {
  @Autowired val collegeDepartmentBiz: CollegeDepartmentBiz = null

  override def importCollegeDepartment(file: String, pageOrder: PageOrder): Unit = {
    collegeDepartmentBiz.multiThreadImportData(file, pageOrder)
  }
}
