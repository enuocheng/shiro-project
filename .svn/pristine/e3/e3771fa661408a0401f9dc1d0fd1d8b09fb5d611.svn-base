package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.Resume
import cn.mycloudedu.user.dto.ResumeBaseDTO
import org.springframework.stereotype.Repository
import java.util.{Map=>JavaMap}

/**
  * Created by e诺
  * on 2017/5/4
  * Time 上午9:56
  */
@Repository
trait ResumeMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Resume): Int

  def insertSelective(record: Resume): Int

  def selectByPrimaryKey(id: Integer): Resume

  def updateByPrimaryKeySelective(record: Resume): Int

  def updateByPrimaryKey(record: Resume): Int

  def getResumeBase(userId: Int): ResumeBaseDTO

  def getJobIntention(userId:Int):JavaMap[String,Any]

  def updateByUserIdSelective(record: Resume): Int

  def getResumeSample(userId: Int): JavaMap[String, Any]
}
