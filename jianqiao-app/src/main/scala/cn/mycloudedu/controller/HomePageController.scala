package cn.mycloudedu.controller

import javax.validation.Valid

import cn.mycloudedu.framework.core.result.{PageOrder, PageResult, TotalResult}
import cn.mycloudedu.user.dto.RecommendPositionDTO
import cn.mycloudedu.user.param.SearchPositionParam
import cn.mycloudedu.user.service.HomePageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RequestParam, ResponseBody}
import java.util.{Map=>JavaMap}

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午2:00
  */
@Controller
@RequestMapping(Array("home"))
class HomePageController extends BaseController {
  @Autowired val homePageService: HomePageService = null

  /**
    * 热门企业
    *
    * @param pageOrder
    * @return
    */
  @RequestMapping(value = Array("hot/company"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getHotCompany(pageOrder: PageOrder): AnyRef = {
    val list: PageResult[JavaMap[String,Any]] = homePageService.hotCompany(pageOrder)
    TotalResult.newInstance(list)
  }

  /**
    * 推荐职位列表
    *
    * @param pageOrder
    * @return
    */
  @RequestMapping(value = Array("recommend/position"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def recommendPosition(pageOrder: PageOrder): AnyRef = {
    val position: PageResult[RecommendPositionDTO] = homePageService.recommendPosition(pageOrder)
    TotalResult.newInstance(position)
  }

  /**
    * 搜索职位
    *
    * @param param
    * @param pageOrder
    * @return
    */
  @RequestMapping(value = Array("position/search"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def searchPosition(@Valid param: SearchPositionParam, pageOrder: PageOrder): AnyRef = {
    val position: PageResult[RecommendPositionDTO] = homePageService.searchPosition(param, pageOrder)
    TotalResult.newInstance(position)
  }

  /**
    * 职位详情
    *
    * @param positionId
    * @return
    */
  @RequestMapping(value = Array("position/details"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def searchPosition(@RequestParam("positionId") positionId: Integer): AnyRef = {
    Assert.notNull(positionId, "positionId:职位id不能为空")
    val positionDetails = homePageService.getPositionDetails(positionId)
    TotalResult.newInstance(positionDetails)
  }

  /**
    * 公司详情
    *
    * @param companyId
    * @return
    */
  @RequestMapping(value = Array("company/details"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getCompanyDetails(@RequestParam("companyId") companyId: Integer): AnyRef = {
    Assert.notNull(companyId, "companyId:公司id不能为空")
    val companyDetails = homePageService.getCompanyDetails(companyId)
    TotalResult.newInstance(companyDetails)
  }

  /**
    * 公司主页
    *
    * @param companyId
    * @return
    */
  @RequestMapping(value = Array("company/homepage"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getCompanyHomePage(@RequestParam("companyId") companyId: Integer): AnyRef = {
    Assert.notNull(companyId, "companyId:公司id不能为空")
    val positionDetails = homePageService.getCompanyHomePage(companyId)
    TotalResult.newInstance(positionDetails)
  }

  /**
    * 某个公司的招聘职位
    *
    * @param companyId
    * @param pageOrder
    * @return
    */
  @RequestMapping(value = Array("position/recruit"), method = Array(RequestMethod.POST, RequestMethod.GET), produces = Array("application/json;charset=utf-8"))
  @ResponseBody def getHotCompany(@RequestParam("companyId") companyId: Integer, pageOrder: PageOrder): AnyRef = {
    Assert.notNull(companyId, "companyId:公司id不能为空")
    val pageResult = homePageService.getRecruitPosition(companyId, pageOrder)
    TotalResult.newInstance(pageResult)
  }
}
