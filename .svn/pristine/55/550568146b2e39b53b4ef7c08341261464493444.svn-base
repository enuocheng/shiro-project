package cn.mycloudedu.user.dao
import java.util.{List => JavaList, Map => JavaMap}

import org.springframework.stereotype.Repository
/**
  * Created by e诺
  * on 2017/5/5
  * Time 下午2:59
  */
@Repository
trait PositionTypeMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Nothing): Int

  def insertSelective(record: Nothing): Int

  def selectByPrimaryKey(id: Integer): Nothing

  def updateByPrimaryKeySelective(record: Nothing): Int

  def updateByPrimaryKey(record: Nothing): Int

  def getPositionType(parentId:Int):JavaList[JavaMap[String,Any]]

  def getResumePositionType(userId: Int): JavaList[JavaMap[String, Any]]
}
