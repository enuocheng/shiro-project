package cn.mycloudedu.user.service

import cn.mycloudedu.user.domain.UserAuth
import java.util.{List => JavaList, Map => JavaMap}

import cn.mycloudedu.user.dto.{AreaDTO, SchoolAuthenticateSuccessDTO, UserInfo}
import cn.mycloudedu.user.param.{SchoolAuthenticationParam, UserInfoParam}

/**
  * Created by e诺
  * on 2017/3/30
  * Time 下午6:05
  */
trait UserService {
  def setLastLoginTime(userId: Int): (Boolean, String, String)

  def getLoginUser(username: String): UserAuth

  def getValidateCode(mobile: String, template: String): Unit

  def checkValidateCode(mobile: String, template: String, code: String): Boolean

  def checkRegisterValidateCode(mobile: String, code: String): Boolean

  def userRegister(mobile: String, password: String): Unit

  def resetPassword(mobile: String, password: String): Unit

  def modifyPassword(userId: Integer, password: String): Unit

  def verifyPassword(userId: Int, password: String): Boolean

  def getBindValidateCode(userId: Int, mobile: String): Boolean

  def checkBindValidateCode(userId: Int, mobile: String, code: String)

  def getArea(parentId: Int): JavaList[JavaMap[Int, String]]

  def getUserInfo(userId: Int): UserInfo

  def saveUserInfo(userId: Int, param: UserInfoParam, birthday: Long): Unit

  def getAreaByLevel(level1Id: Int, level2Id: Int, level3Id: Int = 0): JavaMap[Int, String]

  def authenticateSchool(userId: Int, param: SchoolAuthenticationParam): Boolean

  def getCollege(search: String): JavaList[JavaMap[Int, String]]

  def getCollegeMapId(): JavaList[JavaMap[String, Int]]

  def schoolAuthenticateSuccess(userId: Int): SchoolAuthenticateSuccessDTO

  def isUserSelfMobile(userId: Int, mobile: String): Boolean

  def cacheUuid: String

  def checkUuid(uuid: String): Boolean

  def getAllArea(): JavaList[AreaDTO]
}
