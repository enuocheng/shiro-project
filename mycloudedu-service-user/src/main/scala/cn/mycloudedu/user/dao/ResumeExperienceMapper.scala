package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.ResumeExperience
import cn.mycloudedu.user.dto.ResumeExperienceDTO
import org.springframework.stereotype.Repository
import java.util.{List => JavaList}

import org.apache.ibatis.annotations.Param

/**
  * Created by e诺
  * on 2017/5/10
  * Time 上午9:37
  */
@Repository
trait ResumeExperienceMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: ResumeExperience): Int

  def insertSelective(record: ResumeExperience): Int

  def selectByPrimaryKey(id: Integer): ResumeExperience

  def updateByPrimaryKeySelective(record: ResumeExperience): Int

  def updateByPrimaryKey(record: ResumeExperience): Int

  def getResumeExperienceList(@Param("userId") userId: Int, @Param("resumeId") resumeId: Int, @Param("status") status: Int): JavaList[ResumeExperienceDTO]

  def getResumeExperience(experienceId: Int): ResumeExperienceDTO
}
