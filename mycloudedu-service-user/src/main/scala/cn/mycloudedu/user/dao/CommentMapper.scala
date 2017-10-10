package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.Comment
import cn.mycloudedu.user.dto.CommentDTO
import org.springframework.stereotype.Repository
import java.util.{List => JavaList}

/**
  * Created by e诺
  * on 2017/4/19
  * Time 上午10:23
  */
@Repository
trait CommentMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Comment): Int

  def insertSelective(record: Comment): Int

  def selectByPrimaryKey(id: Integer): Comment

  def updateByPrimaryKeySelective(record: Comment): Int

  def updateByPrimaryKey(record: Comment): Int

  def getLogComment(dailyId: Int): JavaList[CommentDTO]

  def deleteComment(commentId: Int): Int
}
