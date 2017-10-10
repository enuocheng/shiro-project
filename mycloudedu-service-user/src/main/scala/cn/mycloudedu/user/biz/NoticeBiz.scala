package cn.mycloudedu.user.biz

import cn.mycloudedu.framework.core.result.{PageOrder, PageResult}
import cn.mycloudedu.user.dao.NoticeMapper
import cn.mycloudedu.user.domain.Notice
import cn.mycloudedu.user.dto.{NoticeDTO, NoticeDetailsDTO}
import com.github.pagehelper.{PageHelper, PageInfo}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午1:47
  */
@Service
class NoticeBiz {
  @Autowired private val noticeMapper: NoticeMapper = null

  def getNoticeList(userId: Int, pageOrder: PageOrder): PageResult[NoticeDTO] = {
    PageHelper.startPage(pageOrder.getCurrent, pageOrder.getPageSize)
    PageHelper.orderBy(pageOrder.getOrderBy(classOf[Notice]))
    val noticeList = noticeMapper.getNoticeList(userId)
    val pageInfo = new PageInfo[NoticeDTO](noticeList)
    val pageResult = new PageResult[NoticeDTO](pageOrder, pageInfo)
    pageResult
  }

  def getNoticeDetails(noticeId: Int): NoticeDetailsDTO = {
    noticeMapper.getNoticeDetails(noticeId)
  }
}
