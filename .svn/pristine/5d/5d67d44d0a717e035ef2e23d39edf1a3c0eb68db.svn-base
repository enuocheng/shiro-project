package cn.mycloudedu.user.param


import javax.validation.constraints.NotNull

import scala.beans.BeanProperty

/**
  * Created by e诺
  * on 2017/4/19
  * Time 下午5:25
  */
class ReplyCommentParam extends Serializable{
  @NotNull(message = "parentId:评论parentId不能为空")
  @BeanProperty var parentId: Integer = null
  @NotNull(message = "dailyId:日志id不能为空")
  @BeanProperty var dailyId: Integer = null
  @NotNull(message = "content:日志内容不能为空")
  @BeanProperty var content: String = null
  @BeanProperty var toUserId: Integer = null
  @BeanProperty var toTeacherId: Integer = null
}
