package cn.mycloudedu.user.dao

import java.util.{List => JavaList}

import cn.mycloudedu.user.domain.Position
import cn.mycloudedu.user.dto.{PositionDetailsDTO, RecommendPositionDTO, RecruitPositionDTO}
import cn.mycloudedu.user.param.SearchPositionParam
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午3:48
  */
@Repository
trait PositionMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Position): Int

  def insertSelective(record: Position): Int

  def selectByPrimaryKey(id: Integer): Position

  def updateByPrimaryKeySelective(record: Position): Int

  def updateByPrimaryKey(record: Position): Int

  def recommendPosition(): JavaList[RecommendPositionDTO]

  def searchPosition(param: SearchPositionParam): JavaList[RecommendPositionDTO]

  def getPositionDetails(positionId: Int): PositionDetailsDTO

  def getRecruitPosition(companyId: Int):JavaList[RecruitPositionDTO]
}
