package cn.mycloudedu.user.param

import javax.validation.constraints.NotNull
import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/14
  * Time 上午11:21
  */
class SchoolAuthenticationParam extends Serializable {
  @NotNull(message = "name:姓名不能为空")
  @BeanProperty var name: String = null
  @NotNull(message = "number:学号不能为空")
  @BeanProperty var number: String = null
  @NotNull(message = "collegeId:院校Id不能为空")
  @BeanProperty var collegeId: Integer = null
  @NotNull(message = "collegeName:院校名称不能为空")
  @BeanProperty var collegeName: String = null
  @BeanProperty var grade: Int = 0

}
