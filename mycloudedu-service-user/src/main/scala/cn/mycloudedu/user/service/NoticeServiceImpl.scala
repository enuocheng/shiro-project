package cn.mycloudedu.user.service

import cn.mycloudedu.framework.core.result.{PageOrder, PageResult}
import cn.mycloudedu.user.biz.NoticeBiz
import cn.mycloudedu.user.dto.{NoticeDTO, NoticeDetailsDTO}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午3:43
  */
@Service("noticeService")
class NoticeServiceImpl extends NoticeService {
  @Autowired private val noticeBiz: NoticeBiz = null

  override def getNoticeList(userId: Int, pageOrder: PageOrder): PageResult[NoticeDTO] = {
    pageOrder.setDefaultPropertyDirection("createTime", "desc")
    noticeBiz.getNoticeList(userId, pageOrder)
  }

  override def getNoticeDetails(noticeId: Int): NoticeDetailsDTO = {
    noticeBiz.getNoticeDetails(noticeId)
  }
}
