package cn.mycloudedu.user.param

import javax.validation.constraints.NotNull
import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/18
  * Time 上午10:28
  */
class WriteLogParam extends Serializable{
  @NotNull(message = "projectId:项目id不能为空")
  @BeanProperty var projectId: Integer = null
  @NotNull(message = "title:标题不能为空")
  @BeanProperty var title: String = null
  @NotNull(message = "content:内容不能为空")
  @BeanProperty var content: String = null
  @BeanProperty var images: String = null
  @BeanProperty var scope: Integer = null
  @NotNull(message = "status:保存草稿箱或是发布不能为空")
  @BeanProperty var status: Integer = null
  @BeanProperty var id: Integer = null
}
