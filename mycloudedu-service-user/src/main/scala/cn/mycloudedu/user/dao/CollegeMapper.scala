package cn.mycloudedu.user.dao

import java.util.{Map => JavaMap, List => JavaList}

import cn.mycloudedu.user.domain.College
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/14
  * Time 上午11:39
  */
@Repository
trait CollegeMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: College): Int

  def insertSelective(record: College): Int

  def selectByPrimaryKey(id: Integer): College

  def updateByPrimaryKeySelective(record: College): Int

  def updateByPrimaryKey(record: College): Int

  def getCollege(@Param("search") search: String): JavaList[JavaMap[Int, String]]

  def getCollegeMapId(): JavaList[JavaMap[String, Int]]
}
