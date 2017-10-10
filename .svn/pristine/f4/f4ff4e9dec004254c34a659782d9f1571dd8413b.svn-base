package cn.mycloudedu.user.param

import java.util.{List => JavaList}
import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * 求职意向 参数字段
  * Created by e诺
  * on 2017/5/5
  * Time 下午4:30
  */
class JobIntentionParam extends Serializable {
  @NotNull(message = "expectPosition:期望职位不能为空")
  @BeanProperty var expectPosition: JavaList[Integer] = null //期望职位
  @NotNull(message = "positionType:职位类型不能为空")
  @BeanProperty var positionType: Integer = null //职位类型
  @NotNull(message = "expectAddress:期望地址不能为空")
  @BeanProperty var expectAddress: JavaList[Integer] = null //期望地址
  @NotNull(message = "minSalary:最低薪水不能为空")
  @BeanProperty var minSalary: Integer = null //最低薪水
  @NotNull(message = "maxSalary:最高薪水不能为空")
  @BeanProperty var maxSalary: Integer = null //最高薪水
  @NotNull(message = "arrivalTime:到岗时间不能为空")
  @BeanProperty var arrivalTime: Integer = null //到岗时间
}
