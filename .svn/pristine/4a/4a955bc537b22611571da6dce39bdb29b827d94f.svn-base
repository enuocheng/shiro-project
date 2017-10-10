package cn.mycloudedu.user.service

import cn.mycloudedu.framework.core.result.{PageOrder, PageResult}
import cn.mycloudedu.user.dto.{NoticeDTO, NoticeDetailsDTO}

/**
  * Created by e诺
  * on 2017/5/11
  * Time 下午3:42
  */
trait NoticeService {
  def getNoticeList(userId: Int, pageOrder: PageOrder): PageResult[NoticeDTO]

  def getNoticeDetails(noticeId: Int): NoticeDetailsDTO
}
