package cn.mycloudedu.user.param

import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/5/16
  * Time 下午2:11
  */
class ResumeSampleParam {
  @NotNull(message = "sampleName:作品名称不能为空")
  @BeanProperty var sampleName: String = null//作品名称
  @NotNull(message = "sampleFileUrl:作品路径不能为空")
  @BeanProperty var sampleFileUrl: String = null//作品路径
  @NotNull(message = "sampleDescription:作品描述不能为空")
  @BeanProperty var sampleDescription: String = null//作品描述
}
