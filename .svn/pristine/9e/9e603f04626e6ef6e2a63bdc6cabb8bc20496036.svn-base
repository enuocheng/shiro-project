package cn.mycloudedu.user.biz

import java.util.{List => JavaList, Map => JavaMap}

import cn.mycloudedu.framework.core.exception.BusinessException
import cn.mycloudedu.framework.core.utils.{DateUtil, RegexUtil, StringUtil}
import cn.mycloudedu.sms.service.SmsService
import cn.mycloudedu.user.dao._
import cn.mycloudedu.user.domain.{StudentInfo, User, UserAuth}
import cn.mycloudedu.user.dto.{AreaDTO, SchoolAuthenticateSuccessDTO, UserInfo}
import cn.mycloudedu.user.exception.UserErrorCode
import cn.mycloudedu.user.param.{SchoolAuthenticationParam, UserInfoParam}
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by e诺
  * on 2017/3/30
  * Time 下午9:15
  */
@Service
class UserBiz {
  private val log: Logger = Logger.getLogger(this.getClass)
  @Autowired private val userCustomMapper: UserCustomMapper = null
  @Autowired private val userMapper: UserMapper = null
  @Autowired private val smsService: SmsService = null
  @Autowired private val areaMapper: AreaMapper = null
  @Autowired private val collegeMapper: CollegeMapper = null
  @Autowired private val studentInfoMapper: StudentInfoMapper = null

  def setLastLoginTime(userId: Int): (Boolean, String, String) = {
    val user = new User
    user.setId(userId)
    user.setLastLoginTime(DateUtil.getTimeStamp)
    userMapper.updateByPrimaryKeySelective(user)
    this.getStudentInfoByUserId(userId)
  }

  def getStudentInfoByUserId(userId: Int): (Boolean, String, String) = {
    val studentInfo: StudentInfo = studentInfoMapper.getStudentInfoByUserId(userId)
    if (studentInfo == null)
      (false, "", "")
    else if (studentInfo.getVerified == 1) (true, studentInfo.getCollegeName, studentInfo.getName)
    else (false, studentInfo.getCollegeName, studentInfo.getName)
  }

  def getUserByUsername(username: String): UserAuth = {
    userCustomMapper.getUserByUsername(username)
  }

  def getUserByEmail(email: String): UserAuth = {
    userCustomMapper.getUserByEmail(email)
  }

  def getUserByMobile(mobile: String): UserAuth = {
    userCustomMapper.getUserByMobile(mobile)
  }

  def getUserByMobileExceptSelf(userId: Int, mobile: String): UserAuth = {
    userCustomMapper.getUserByMobileExceptSelf(userId, mobile)
  }

  def getLoginUser(username: String): UserAuth = {
    var userAuth: UserAuth = null
    if (RegexUtil.isUsername(username)) {
      userAuth = this.getUserByUsername(username)
    }
    else if (RegexUtil.isEmail(username)) {
      userAuth = this.getUserByEmail(username)
    }
    else if (RegexUtil.isMobile(username)) {
      userAuth = this.getUserByMobile(username)
    }
    else {
      throw new BusinessException(UserErrorCode(UserErrorCode.USERNAME_REGEX_ERROR))
    }
    userAuth
  }

  def getForgetValidateCode(mobile: String, template: String): Unit = {
    this.RegexMobileValidateCode(mobile, template)
  }

  def getRegisterValidateCode(mobile: String, template: String): Unit = {
    if (!RegexUtil.isMobile(mobile)) {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_REGEX_ERROR))
    }
    val user = this.getUserByMobile(mobile)

    if (user != null) {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_EXISTS_ERROR))
    }
    else {
      smsService.generateCode(mobile, template)
    }
  }

  def getBindValidateCode(mobile: String, template: String): Unit = {
    smsService.generateCode(mobile, template)
  }

  def getModifyValidateCode(mobile: String, template: String): Unit = {
    if (!RegexUtil.isMobile(mobile)) {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_REGEX_ERROR))
    }
    val user = this.getUserByMobile(mobile)
    if (user != null) {
      smsService.generateCode(mobile, template)
    }
    else {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_NOTFOUND_ERROR))
    }
  }

  def RegexMobileValidateCode(mobile: String, template: String): Unit = {
    if (!RegexUtil.isMobile(mobile)) {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_REGEX_ERROR))
    }
    val user = this.getUserByMobile(mobile)
    if (user != null) {
      smsService.generateCode(mobile, template)
    }
    else {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_NOTFOUND_ERROR))
    }
  }

  def getArea(parentId: Int): JavaList[JavaMap[Int, String]] = {
    areaMapper.getArea(parentId)
  }

  def getAreaByLevel(level1Id: Int, level2Id: Int, level3Id: Int = 0): JavaMap[Int, String] = {
    val result = if (level3Id > 0) 1 else 0
    result match {
      case 1 => this.getAreaByLevel3(level1Id: Int, level2Id: Int, level3Id: Int)
      case 0 => this.getAreaByLevel2(level1Id: Int, level2Id: Int)
    }
  }

  def getAreaByLevel2(level1Id: Int, level2Id: Int): JavaMap[Int, String] = {
    areaMapper.getAreaByLevel2(level1Id, level2Id)
  }

  def getAreaByLevel3(level1Id: Int, level2Id: Int, level3Id: Int): JavaMap[Int, String] = {
    areaMapper.getAreaByLevel3(level1Id, level2Id, level3Id)
  }

  def getUserInfo(userId: Int): UserInfo = {
    val userInfo = userCustomMapper.getUserInfo(userId)
    if (userInfo != null) {
      val level: JavaMap[Int, String] = getAreaByLevel(userInfo.getProvince, userInfo.getCity)

      if (level != null) {
        userInfo.setProvinceName(level.get("province").toString)
        userInfo.setCityName(level.get("city").toString)
      }
      userInfo
    }
    else null
  }


  def saveUserInfo(userId: Int, param: UserInfoParam, birthday: Long): Unit = {
    val user = userMapper.selectByPrimaryKey(userId)
    if (user != null) {
      user.setAvatar(param.getAvatar)
      user.setBirthday(birthday)
      user.setNickname(param.getNickname)
      val province = param.getProvince
      val city = param.getCity
      if (province != 0 && city != 0) {
        user.setProvince(province)
        user.setCity(city)
      }
      val email = param.getEmail
      if (email != null && !"".equals(email)) {
        if (!RegexUtil.isEmail(email))
          throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_REGEX_ERROR))
        user.setEmailVerified(1)
      }
      user.setEmail(email)
      userMapper.updateByPrimaryKeySelective(user)
    }
  }

  def authenticateSchool(userId: Int, param: SchoolAuthenticationParam): Boolean = {
    val name = StringUtil.removeSpaces(param.getName)
    val number = StringUtil.removeSpaces(param.getNumber)
    val collegeName = StringUtil.removeSpaces(param.getCollegeName)
    val info = studentInfoMapper.getStudentInfoByIds(param.getCollegeId, userId)
    if (info != null) {
      val studentName = StringUtil.removeSpaces(info.getName)
      val studentNumber = StringUtil.removeSpaces(info.getNumber)
      val studentCollegeName = StringUtil.removeSpaces(info.getCollegeName)
      if (name.equals(studentName) && number.equals(studentNumber) && collegeName.equals(studentCollegeName)) {
        info.setVerified(1)
        info.setVerifiedTime(DateUtil.getTimeStamp)
        studentInfoMapper.updateByPrimaryKeySelective(info)
      } else if (!name.equals(studentName))
        throw new BusinessException(UserErrorCode(UserErrorCode.STUDENT_NAME_ERROR))
      else if (!number.equals(studentNumber))
        throw new BusinessException(UserErrorCode(UserErrorCode.STUDENT_NUMBER_ERROR))
      else if (!collegeName.equals(studentCollegeName))
        throw new BusinessException(UserErrorCode(UserErrorCode.STUDENT_SCHOOL_ERROR))
      true
    }
    else {
      throw new BusinessException(UserErrorCode(UserErrorCode.SCHOOL_AUTH_ERROR))
    }
  }

  def getCollege(search: String): JavaList[JavaMap[Int, String]] = {
    collegeMapper.getCollege(search)
  }

  def getCollegeMapId(): JavaList[JavaMap[String, Int]] = {
    collegeMapper.getCollegeMapId()
  }

  def schoolAuthenticateSuccess(userId: Int): SchoolAuthenticateSuccessDTO = {
    studentInfoMapper.schoolAuthenticateSuccess(userId)
  }

  def isUserSelfMobile(userId: Int, mobile: String): Boolean = {
    if (!RegexUtil.isMobile(mobile)) {
      throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_REGEX_ERROR))
    }
    val userAuth = userCustomMapper.getUserById(userId)
    userAuth match {
      case user: UserAuth =>
        if (StringUtil.removeSpaces(mobile).equals(StringUtil.removeSpaces(user.getMobile))) true
        else throw new BusinessException(UserErrorCode(UserErrorCode.MOBILE_SELF_ERROR))
      case _ => throw new BusinessException(UserErrorCode(UserErrorCode.USER_NOTFOUND_ERROR))
    }
  }

  def getAllArea(): JavaList[AreaDTO]={
    areaMapper.getAllArea()
  }
}
