package cn.mycloudedu.user.dao

import cn.mycloudedu.user.domain.StudentInfo
import cn.mycloudedu.user.dto.SchoolAuthenticateSuccessDTO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
  * Created by e诺
  * on 2017/4/14
  * Time 下午1:57
  */
@Repository
trait StudentInfoMapper {
  def deleteByPrimaryKey(id: Integer): Int

  def insert(record: StudentInfo): Int

  def insertSelective(record: StudentInfo): Int

  def selectByPrimaryKey(id: Integer): StudentInfo

  def updateByPrimaryKeySelective(record: StudentInfo): Int

  def updateByPrimaryKey(record: StudentInfo): Int

  def getStudentInfoByIds(@Param("collegeId") collegeId: Int, @Param("userId") userId: Int): StudentInfo

  def getStudentInfoByUserId(userId: Int): StudentInfo

  def schoolAuthenticateSuccess(userId: Int): SchoolAuthenticateSuccessDTO
}
