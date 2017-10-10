package cn.mycloudedu.user.dao

import java.util.{List => JavaList}

import cn.mycloudedu.user.domain.Notice
import cn.mycloudedu.user.dto.{NoticeDTO, NoticeDetailsDTO}
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午1:51
  */
@Repository
trait NoticeMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Notice): Int

  def insertSelective(record: Notice): Int

  def selectByPrimaryKey(id: Integer): Notice

  def updateByPrimaryKeySelective(record: Notice): Int

  def updateByPrimaryKey(record: Notice): Int

  def getNoticeList(userId: Int): JavaList[NoticeDTO]

  def getNoticeDetails(noticeId: Int): NoticeDetailsDTO
}
