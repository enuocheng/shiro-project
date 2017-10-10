package cn.mycloudedu.user.service

import cn.mycloudedu.user.dto.{ResumeBaseDTO, ResumeEducationDTO, ResumeExperienceDTO}
import cn.mycloudedu.user.param._
import java.util.{List => JavaList, Map => JavaMap}

/**
  * Created by e诺
  * on 2017/5/4
  * Time 上午8:50
  */
trait ResumeService {
  def getAvatar(userId: Int): String

  def setAvatar(userId: Int, avatar: String): Unit

  def setResumeBaseInfo(userId: Int, param: ResumeBaseInfoParam): Unit

  def getResumeBaseInfo(userId: Int): ResumeBaseDTO

  def setPersonalAdvantage(userId: Int, advantage: String): Unit

  def getPersonalAdvantage(userId: Int): String

  def getPositionType(parentId: Int): JavaList[JavaMap[String, Any]]

  def getResumePositionType(userId: Int): JavaList[JavaMap[String, Any]]

  def getJobIntention(userId: Int): JavaMap[String, Any]

  def setJobIntention(userId: Int, param: JobIntentionParam): Unit

  def getResumeArea(userId: Int): JavaList[JavaMap[String, Any]]

  def getResumeExperienceList(userId: Int, status: Int): JavaList[ResumeExperienceDTO]

  def getResumeExperience(experienceId: Int): ResumeExperienceDTO

  def setResumeExperience(userId: Int, param: ResumeExperienceParam, status: Int): Unit

  def updateResumeExperience(experienceId: Int, param: ResumeExperienceParam): Unit

  def deleteResumeExperience(userId: Int, experienceId: Int, status: Int): Unit

  def getResumeEducation(educationId: Int): ResumeEducationDTO

  def getResumeEducationList(userId: Int): JavaList[ResumeEducationDTO]

  def setResumeEducation(userId: Int, param: ResumeEducationParam): Unit

  def updateResumeEducation(educationId: Int, param: ResumeEducationParam): Unit

  def deleteResumeEducation(userId: Int, educationId: Int): Unit

  def getResumeSample(userId: Int): JavaMap[String, Any]

  def setResumeSample(userId: Int, param: ResumeSampleParam): Unit
}
