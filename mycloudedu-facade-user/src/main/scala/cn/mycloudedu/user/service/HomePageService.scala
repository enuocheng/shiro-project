package cn.mycloudedu.user.service

import java.util.{List => JavaList, Map => JavaMap}

import cn.mycloudedu.framework.core.result.{PageOrder, PageResult}
import cn.mycloudedu.user.dto._
import cn.mycloudedu.user.param.SearchPositionParam

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午2:29
  */
trait HomePageService {
  def hotCompany(pageOrder: PageOrder): PageResult[JavaMap[String,Any]]

  def recommendPosition(pageOrder: PageOrder): PageResult[RecommendPositionDTO]

  def searchPosition(param: SearchPositionParam, pageOrder: PageOrder): PageResult[RecommendPositionDTO]

  def getPositionDetails(positionId: Int): PositionDetailsDTO

  def getCompanyHomePage(companyId: Int): CompanyHomePageDTO

  def getCompanyDetails(companyId: Int): CompanyBaseDTO

  def getRecruitPosition(companyId: Int, pageOrder: PageOrder): PageResult[RecruitPositionDTO]
}
