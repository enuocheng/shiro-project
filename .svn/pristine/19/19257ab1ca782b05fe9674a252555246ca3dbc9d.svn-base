package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.ResumePositionType
import org.springframework.stereotype.Repository
import java.util.{List => JavaList}

/**
  * Created by e诺
  * on 2017/5/9
  * Time 下午2:04
  */
@Repository
trait ResumePositionTypeMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: ResumePositionType): Int

  def insertSelective(record: ResumePositionType): Int

  def selectByPrimaryKey(id: Integer): ResumePositionType

  def updateByPrimaryKeySelective(record: ResumePositionType): Int

  def updateByPrimaryKey(record: ResumePositionType): Int

  def batchInsertResumePositionType(list: JavaList[ResumePositionType]): Unit

  def deleteResumePositionType(userId: Int): Int
}
