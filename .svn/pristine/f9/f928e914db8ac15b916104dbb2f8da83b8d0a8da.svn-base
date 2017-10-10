package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.User
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/12
  * Time 上午10:26
  */
@Repository
trait UserMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: User): Int

  def insertSelective(record: User): Int

  def selectByPrimaryKey(id: Int): User

  def updateByPrimaryKeySelective(record: User): Int

  def updateByPrimaryKey(record: User): Int
}
