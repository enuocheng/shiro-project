package cn.mycloudedu.user.service

import java.util.{List => JavaList, Map => JavaMap}

import cn.mycloudedu.framework.core.result.{PageOrder, PageResult}
import cn.mycloudedu.user.biz.HomePageBiz
import cn.mycloudedu.user.dto._
import cn.mycloudedu.user.param.SearchPositionParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午2:30
  */
@Service("homePageService")
class HomePageServiceImpl extends HomePageService {
  @Autowired val homePageBiz: HomePageBiz = null

  override def hotCompany(pageOrder: PageOrder): PageResult[JavaMap[String,Any]] = {
    pageOrder.setDefaultPropertyDirection("approvedTime", "desc")
    homePageBiz.hotCompany(pageOrder)
  }

  override def recommendPosition(pageOrder: PageOrder): PageResult[RecommendPositionDTO] = {
    pageOrder.setDefaultPropertyDirection("updateTime", "desc")
    homePageBiz.recommendPosition(pageOrder)
  }

  override def searchPosition(param: SearchPositionParam, pageOrder: PageOrder): PageResult[RecommendPositionDTO] = {
    pageOrder.setDefaultPropertyDirection("updateTime", "desc")
    homePageBiz.searchPosition(param, pageOrder)
  }

  override def getPositionDetails(positionId: Int): PositionDetailsDTO = {
    homePageBiz.getPositionDetails(positionId)
  }

  override def getCompanyHomePage(companyId: Int): CompanyHomePageDTO = {
    homePageBiz.getCompanyHomePage(companyId)
  }

  override def getCompanyDetails(companyId: Int): CompanyBaseDTO = {
    homePageBiz.getCompanyDetails(companyId)
  }

  override def getRecruitPosition(companyId: Int, pageOrder: PageOrder): PageResult[RecruitPositionDTO] = {
    pageOrder.setDefaultPropertyDirection("updateTime", "desc")
    homePageBiz.getRecruitPosition(companyId, pageOrder)
  }
}
