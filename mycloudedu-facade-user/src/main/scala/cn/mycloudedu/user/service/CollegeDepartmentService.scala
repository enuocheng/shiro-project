package cn.mycloudedu.user.service

import cn.mycloudedu.framework.core.result.PageOrder

/**
  * Created by e诺
  * on 2017/4/25
  * Time 上午9:36
  */
trait CollegeDepartmentService {
  def importCollegeDepartment(file: String, pageOrder: PageOrder): Unit
}
