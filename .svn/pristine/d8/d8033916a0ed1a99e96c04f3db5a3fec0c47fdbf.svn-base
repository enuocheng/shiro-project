package cn.mycloudedu.user.dao

import cn.mycloudedu.user.dto.{EditLogPlanDTO, PracticePlanDTO, PracticePlanDetailsDTO}
import org.springframework.stereotype.Repository
import java.util.{List => JavaList}

import org.apache.ibatis.annotations.Param


/**
  * Created by e诺
  * on 2017/4/17
  * Time 下午2:50
  */
@Repository
trait PracticeMapper {
  def getPracticePlanList(userId: Int): JavaList[PracticePlanDTO]

  def getPracticePlanDetails(@Param("userId") userId: Int, @Param("projectId") projectId: Int): PracticePlanDetailsDTO

  def getEditLogPlanList(@Param("userId") userId: Int): JavaList[EditLogPlanDTO]
}
