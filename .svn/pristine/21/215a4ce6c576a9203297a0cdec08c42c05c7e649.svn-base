package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.UserAuth
import cn.mycloudedu.user.dto.UserInfo
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/3/30
  * Time 下午9:16
  */
@Repository
trait UserCustomMapper {
  def getUserByUsername(username: String): UserAuth

  def getUserByEmail(email: String): UserAuth

  def getUserByMobile(mobile: String): UserAuth

  def getUserById(userId: Int): UserAuth

  def getUserByMobileExceptSelf(@Param("userId") userId: Int, @Param("mobile") mobile: String): UserAuth

  def getUserInfo(userId: Int): UserInfo
}
