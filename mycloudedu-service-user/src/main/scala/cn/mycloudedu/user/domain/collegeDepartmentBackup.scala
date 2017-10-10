package cn.mycloudedu.user.domain

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/25
  * Time 下午8:49
  */
class collegeDepartmentBackup {
  @BeanProperty var id: Integer = null
  @BeanProperty var name: String = null
  @BeanProperty var parentId: Integer = null
  @BeanProperty var level: Integer = null
  @BeanProperty var collegeId: Integer = null
}
