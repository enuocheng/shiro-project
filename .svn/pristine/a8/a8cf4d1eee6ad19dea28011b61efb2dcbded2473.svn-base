package cn.mycloudedu.user.biz

import java.util.{List => JavaList}

import cn.mycloudedu.framework.core.exception.BusinessException
import cn.mycloudedu.framework.core.result.{PageOrder, PageResult}
import cn.mycloudedu.framework.core.utils.DateUtil
import cn.mycloudedu.user.dao.{CommentMapper, DailyMapper, PracticeMapper, ProjectMapper}
import cn.mycloudedu.user.domain.{Comment, Daily, Project}
import cn.mycloudedu.user.dto._
import cn.mycloudedu.user.exception.UserErrorCode
import cn.mycloudedu.user.param.{ReplyCommentParam, WriteCommentParam, WriteLogParam}
import com.github.pagehelper.{PageHelper, PageInfo}
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by e诺
  * on 2017/4/17
  * Time 下午2:17
  */

@Service
class PracticeBiz {
  @Autowired val practiceMapper: PracticeMapper = null
  @Autowired val dailyMapper: DailyMapper = null
  @Autowired val commentMapper: CommentMapper = null
  @Autowired val projectMapper: ProjectMapper = null

  def getPracticePlanList(userId: Int, pageOrder: PageOrder): PageResult[PracticePlanDTO] = {
    PageHelper.startPage(pageOrder.getCurrent, pageOrder.getPageSize)
    PageHelper.orderBy(pageOrder.getOrderBy(classOf[Project]))
    val practicePlanList: JavaList[PracticePlanDTO] = practiceMapper.getPracticePlanList(userId)
    val pageInfo: PageInfo[PracticePlanDTO] = new PageInfo(practicePlanList)
    val pageResult: PageResult[PracticePlanDTO] = new PageResult(pageOrder, pageInfo)
    pageResult
  }

  def getEditLogPlanList(userId: Int): JavaList[EditLogPlanDTO] = {
    practiceMapper.getEditLogPlanList(userId)
  }

  def getPracticePlanDetails(userId: Int, projectId: Int): PracticePlanDetailsDTO = {
    practiceMapper.getPracticePlanDetails(userId, projectId)
  }

  def writeLog(userId: Int, param: WriteLogParam, create: Boolean): Unit = {
    val daily = new Daily
    daily.setUserId(userId)
    daily.setProjectId(param.getProjectId)
    daily.setTitle(param.getTitle)
    daily.setContent(param.getContent)
    if (param.getStatus == 1) {
      daily.setPublishTime(DateUtil.getTimeStamp)
    }
    daily.setStatus(param.getStatus)
    if (param.getImages != null && !"".equals(param.getImages))
      daily.setImages(param.getImages)
    if (param.getScope != null)
      daily.setScope(param.getScope)
    if (create) {
      daily.setCreateTime(DateUtil.getTimeStamp)
      dailyMapper.insertSelective(daily)
    }
    else {
      daily.setId(param.getId)
      daily.setUpdateTime(DateUtil.getTimeStamp)
      dailyMapper.updateByPrimaryKeySelective(daily)
    }
  }

  def getDraftsLogList(userId: Int, pageOrder: PageOrder): PageResult[DraftsLogDTO] = {
    PageHelper.startPage(pageOrder.getCurrent, pageOrder.getPageSize)
    PageHelper.orderBy(pageOrder.getOrderBy(classOf[Daily]))
    val logList: JavaList[DraftsLogDTO] = dailyMapper.getDraftsLogList(userId)
    val pageInfo = new PageInfo[DraftsLogDTO](logList)
    val pageResult = new PageResult[DraftsLogDTO](pageOrder, pageInfo)
    pageResult
  }

  def getEditLog(dailyId: Int): EditLogDTO = {
    val daily: Daily = dailyMapper.selectByPrimaryKey(dailyId)
    val editLogDTO = new EditLogDTO
    if (daily != null) {
      val project = projectMapper.selectByPrimaryKey(daily.projectId)
      BeanUtils.copyProperties(daily, editLogDTO)
      editLogDTO.setProjectName(project.name)
    }
    editLogDTO
  }

  def deleteDraftsLog(dailyId: Int): Unit = {
    dailyMapper.deleteDraftsLog(dailyId)
  }

  def getMyLogList(userId: Int, pageOrder: PageOrder): PageResult[MyLogDTO] = {
    PageHelper.startPage(pageOrder.getCurrent, pageOrder.getPageSize)
    PageHelper.orderBy(pageOrder.getOrderBy(classOf[Daily]))
    val logList: JavaList[MyLogDTO] = dailyMapper.getMyLogList(userId)
    val pageInfo = new PageInfo[MyLogDTO](logList)
    val pageResult = new PageResult[MyLogDTO](pageOrder, pageInfo)
    pageResult
  }

  def getLogDetails(userId: Int, dailyId: Int): MyLogDTO = {
    dailyMapper.getLogDetails(userId, dailyId)
  }

  def getLogComment(dailyId: Int): JavaList[CommentDTO] = {
    commentMapper.getLogComment(dailyId)
  }

  def writeComment(userId: Int, param: WriteCommentParam): Unit = {
    val comment = new Comment
    comment.setContent(param.getContent)
    comment.setDailyId(param.getDailyId)
    comment.setLevel(1)
    comment.setUserId(userId)
    comment.setCreateTime(DateUtil.getTimeStamp)
    commentMapper.insertSelective(comment)
  }

  def replyComment(userId: Int, param: ReplyCommentParam): Unit = {
    val comment = new Comment
    comment.setUserId(userId)
    comment.setParentId(param.getParentId)
    comment.setDailyId(param.getDailyId)
    comment.setContent(param.getContent)
    comment.setCreateTime(DateUtil.getTimeStamp)
    comment.setLevel(2)
    if (param.getToUserId != null)
      comment.setToUserId(param.getToUserId)
    if (param.getToTeacherId != null)
      comment.setToTeacherId(param.getToTeacherId)
    commentMapper.insertSelective(comment)
  }

  def deleteComment(commentId: Int): Boolean = {
    val result: Int = commentMapper.deleteComment(commentId)
    if (result > 0) true
    else false
  }

  def isSelfComment(commentId: Int, userId: Int): Boolean = {
    val comment: Comment = commentMapper.selectByPrimaryKey(commentId)
    val result: Boolean = userId.equals(comment.getUserId)
    result match {
      case true => result
      case _ => throw new BusinessException(UserErrorCode(UserErrorCode.IS_NOT_SELF_COMMENT))
    }
  }
}
