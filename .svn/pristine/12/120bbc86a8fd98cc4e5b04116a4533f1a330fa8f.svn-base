package cn.mycloudedu.user.dao

import java.util.{List => JavaList}

import cn.mycloudedu.user.domain.CollegeDepartment
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/25
  * Time 下午8:50
  */
@Repository
trait CollegeDepartmentBackupMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: CollegeDepartment): Int

  def insertSelective(record: CollegeDepartment): Int

  def selectByPrimaryKey(id: Integer): CollegeDepartment

  def updateByPrimaryKeySelective(record: CollegeDepartment): Int

  def updateByPrimaryKey(record: CollegeDepartment): Int

  def batchInsertImportData(record: JavaList[CollegeDepartment]): Unit
}
