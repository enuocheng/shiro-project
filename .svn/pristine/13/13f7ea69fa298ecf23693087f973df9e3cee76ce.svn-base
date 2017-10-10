package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.Project
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/17
  * Time 下午3:32
  */
@Repository
trait ProjectMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Project): Int

  def insertSelective(record: Project): Int

  def selectByPrimaryKey(id: Integer): Project

  def updateByPrimaryKeySelective(record: Project): Int

  def updateByPrimaryKey(record: Project): Int
}
