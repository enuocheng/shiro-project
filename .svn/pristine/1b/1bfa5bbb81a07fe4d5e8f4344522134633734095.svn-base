package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.ResumeEducation
import cn.mycloudedu.user.dto.ResumeEducationDTO
import org.springframework.stereotype.Repository
import java.util.{List=>JavaList}

/**
  * Created by e诺
  * on 2017/5/15
  * Time 下午5:44
  */
@Repository
trait ResumeEducationMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: ResumeEducation): Int

  def insertSelective(record: ResumeEducation): Int

  def selectByPrimaryKey(id: Integer): ResumeEducation

  def updateByPrimaryKeySelective(record: ResumeEducation): Int

  def updateByPrimaryKey(record: ResumeEducation): Int

  def getResumeEducation(educationId:Int):ResumeEducationDTO

  def getResumeEducationList(userId:Int):JavaList[ResumeEducationDTO]
}
