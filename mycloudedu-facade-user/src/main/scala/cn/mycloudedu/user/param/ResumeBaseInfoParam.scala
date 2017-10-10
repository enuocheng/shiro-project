package cn.mycloudedu.user.param

import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/5
  * Time 上午9:19
  */
class ResumeBaseInfoParam extends Serializable{
  @NotNull(message = "name:姓名不能为空")
  @BeanProperty var name: String = null
  @NotNull(message = "sex:性别不能为空")
  @BeanProperty var sex: Integer = null
  @NotNull(message = "birthday:出生年月不能为空")
  @BeanProperty var birthday: Long = 0
  @NotNull(message = "provinceId:省Id不能为空")
  @BeanProperty var provinceId: Integer = null
  @NotNull(message = "provinceName:省名称不能为空")
  @BeanProperty var provinceName: String = null
  @NotNull(message = "cityId:城市Id不能为空")
  @BeanProperty var cityId: Integer = null
  @NotNull(message = "cityName:姓名不能为空")
  @BeanProperty var cityName: String = null
  @NotNull(message = "education:学历不能为空")
  @BeanProperty var education: Integer = null
  @NotNull(message = "mobile:手机不能为空")
  @BeanProperty var mobile: String = null
  @NotNull(message = "email:学历不能为空")
  @BeanProperty var email: String = null
}
