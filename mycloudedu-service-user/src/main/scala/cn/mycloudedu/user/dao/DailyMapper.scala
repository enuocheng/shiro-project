package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.Daily
import cn.mycloudedu.user.dto.{MyLogDTO, DraftsLogDTO}
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository
import java.util.{List => JavaList}

/**
  * Created by e诺
  * on 2017/4/18
  * Time 上午10:37
  */
@Repository
trait DailyMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Daily): Int

  def insertSelective(record: Daily): Int

  def selectByPrimaryKey(id: Integer): Daily

  def updateByPrimaryKeySelective(record: Daily): Int

  def updateByPrimaryKey(record: Daily): Int

  def getDraftsLogList(useId: Int): JavaList[DraftsLogDTO]

  def getMyLogList(useId: Int): JavaList[MyLogDTO]

  def getLogDetails(@Param("userId") userId: Int, @Param("dailyId") dailyId: Int): MyLogDTO

  def deleteDraftsLog(dailyId:Int):Unit
}
