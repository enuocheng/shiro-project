package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.ResumeArea
import org.springframework.stereotype.Repository
import java.util.{List=>JavaList,Map=>JavaMap}
/**
  * Created by e诺
  * on 2017/5/9
  * Time 下午2:10
  */
@Repository
trait ResumeAreaMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: ResumeArea): Int

  def insertSelective(record: ResumeArea): Int

  def selectByPrimaryKey(id: Integer): ResumeArea

  def updateByPrimaryKeySelective(record: ResumeArea): Int

  def updateByPrimaryKey(record: ResumeArea): Int

  def batchInsertResumeArea(list: JavaList[ResumeArea])

  def deleteResumeArea(userId:Int):Int

  def getResumeArea(userId: Int): JavaList[JavaMap[String, Any]]
}
