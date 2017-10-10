package cn.mycloudedu.user.dao

import java.util.{List => JavaList,Map=>JavaMap}

import cn.mycloudedu.user.domain.Company
import cn.mycloudedu.user.dto.{CompanyBaseDTO, CompanyHomePageDTO}
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/20
  * Time 下午2:23
  */
@Repository
trait CompanyMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: Company): Int

  def insertSelective(record: Company): Int

  def selectByPrimaryKey(id: Integer): Company

  def updateByPrimaryKeySelective(record: Company): Int

  def updateByPrimaryKey(record: Company): Int

  def hotCompany(): JavaList[JavaMap[String,Any]]

  def getCompanyDetails(companyId: Int): CompanyBaseDTO

  def getCompanyHomePage(companyId: Int): CompanyHomePageDTO
}
