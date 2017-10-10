package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.CollegeDepartment
import org.springframework.stereotype.Repository
import java.util.{List => JavaList}

/**
  * Created by e诺
  * on 2017/4/25
  * Time 上午9:30
  */
@Repository
trait CollegeDepartmentMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: CollegeDepartment): Int

  def insertSelective(record: CollegeDepartment): Int

  def selectByPrimaryKey(id: Integer): CollegeDepartment

  def updateByPrimaryKeySelective(record: CollegeDepartment): Int

  def updateByPrimaryKey(record: CollegeDepartment): Int

  def batchInsertImportData(record: JavaList[CollegeDepartment]): Unit
}
