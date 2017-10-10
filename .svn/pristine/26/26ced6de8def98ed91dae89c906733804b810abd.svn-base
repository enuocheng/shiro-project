package cn.mycloudedu.framework.web.filters

import java.io.IOException
import java.util.{HashMap => JavaHashMap, Map => JavaMap}
import javax.servlet.http.HttpServletRequest
import javax.servlet.{ServletRequest, ServletResponse}

import org.apache.shiro.web.filter.authc.UserFilter

/**
  * Created by e诺
  * on 2017/3/30
  * Time 下午8:33
  */
class UserAutowiredFilter extends UserFilter{
  override def setLoginUrl(loginUrl: String) {
    super.setLoginUrl(loginUrl)
  }

  protected override def isAccessAllowed(request: ServletRequest, response: ServletResponse, mappedValue: AnyRef): Boolean = {
    return super.isAccessAllowed(request, response, mappedValue)
  }

  @throws(classOf[Exception])
  protected override def onAccessDenied(request: ServletRequest, response: ServletResponse): Boolean = {
    return super.onAccessDenied(request, response)
  }

  @throws(classOf[IOException])
  protected override def redirectToLogin(request: ServletRequest, response: ServletResponse) {
    val loginUrl: String = getLoginUrl
    val callback: String = request.getParameter("callback")
    val token: String = request.getParameter("token")
    val map: JavaMap[String, AnyRef] = new JavaHashMap[String, AnyRef]
    if (callback != null) {
      map.put("callback", callback)
    }
    if (token != null) {
      map.put("token", token)
    }
    val hRequest: HttpServletRequest = request.asInstanceOf[HttpServletRequest]
    try {
      hRequest.getRequestDispatcher(loginUrl).forward(request, response)
    }
    catch {
      case e: Exception => {
        System.out.println("转发出错！")
      }
    }
  }
}
