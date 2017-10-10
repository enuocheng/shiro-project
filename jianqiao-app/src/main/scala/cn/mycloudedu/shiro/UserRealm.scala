package cn.mycloudedu.shiro

import cn.mycloudedu.user.config.UserConfig
import cn.mycloudedu.user.domain.UserAuth
import cn.mycloudedu.user.dto.UserResult
import cn.mycloudedu.user.service.UserService
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.{AuthenticationException, AuthenticationInfo, AuthenticationToken, SimpleAuthenticationInfo}
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.session.Session
import org.apache.shiro.subject.{PrincipalCollection, Subject}
import org.apache.shiro.util.ByteSource
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired

/**
  * Created by e诺
  * on 2017/3/30
  * Time 下午9:09
  */
class UserRealm extends AuthorizingRealm with Serializable{
  @Autowired private val userService: UserService = null
  @Autowired private val userConfig:UserConfig=null

  override def doGetAuthorizationInfo(principals: PrincipalCollection): AuthorizationInfo = {
    return null
  }

  @throws(classOf[AuthenticationException])
  protected def doGetAuthenticationInfo(authenticationToken: AuthenticationToken): AuthenticationInfo = {
    val username: String = authenticationToken.getPrincipal.asInstanceOf[String]
    val userAuth: UserAuth =userService.getLoginUser(username)
    val userResult: UserResult = new UserResult
    var authenticationInfo: SimpleAuthenticationInfo = null
    if (userAuth != null) {
      BeanUtils.copyProperties(userAuth, userResult)
      authenticationInfo = new SimpleAuthenticationInfo(userAuth.getUsername, userAuth.getPassword, ByteSource.Util.bytes(userConfig.getUserSalt), getName)
    }
    val subject: Subject = SecurityUtils.getSubject
    val session: Session = subject.getSession
    userResult.setToken(session.getId.toString)
    session.setAttribute("user", userResult)
    authenticationInfo
  }
}
