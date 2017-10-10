package cn.mycloudedu.shiro

import java.util.concurrent.atomic.AtomicInteger

import org.apache.shiro.authc.credential.HashedCredentialsMatcher
import org.apache.shiro.authc.{AuthenticationInfo, AuthenticationToken, ExcessiveAttemptsException}
import org.apache.shiro.cache.{Cache, CacheManager}

/**
  * Created by e诺
  * on 2017/3/30
  * Time 下午9:05
  */
class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{
  private var passwordRetryCache: Cache[String, AtomicInteger] = null

  def this(cacheManager: CacheManager) {
    this()
    passwordRetryCache = cacheManager.getCache("passwordRetryCache")
  }

  override def doCredentialsMatch(token: AuthenticationToken, info: AuthenticationInfo): Boolean = {
    val username: String = token.getPrincipal.asInstanceOf[String]
    var retryCount: AtomicInteger = passwordRetryCache.get(username)
    if (retryCount == null) {
      retryCount = new AtomicInteger(0)
      passwordRetryCache.put(username, retryCount)
    }
    if (retryCount.incrementAndGet > 5) {
      throw new ExcessiveAttemptsException
    }
    val matches: Boolean = super.doCredentialsMatch(token, info)
    if (matches) {
      passwordRetryCache.remove(username)
    }
    System.out.println("用户尝试密码" + retryCount + "次")
    return matches
  }
}
