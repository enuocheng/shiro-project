package cn.mycloudedu.shiro

import cn.mycloudedu.user.domain.UserBase
import org.apache.shiro.SecurityUtils
import org.apache.shiro.session.Session
import org.apache.shiro.subject.Subject

/**
  * Created by e诺
  * on 2017/4/13
  * Time 上午11:49
  */
class ShiroUtil {

}

object ShiroUtil {
  def getAttribute(o: AnyRef): AnyRef = {
    val subject: Subject = SecurityUtils.getSubject
    val session: Session = subject.getSession
    session.getAttribute(o)
  }

  def getUser: UserBase = {
    val subject: Subject = SecurityUtils.getSubject
    val session: Session = subject.getSession
    val userObject: AnyRef = session.getAttribute("user")
    if (userObject == null) {
      null
    }
    else {
      var user: UserBase = null
      if (userObject.isInstanceOf[UserBase]) {
        user = userObject.asInstanceOf[UserBase]
      }
      user
    }
  }

  def getUserId: Int = {
    getUser.getId
  }
}
