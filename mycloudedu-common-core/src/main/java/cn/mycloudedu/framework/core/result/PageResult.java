package cn.mycloudedu.framework.core.result;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/6/27.
 */
public class PageResult<T>  extends Page {
    private  long total;//
    private  int pages=1;
    private List<T> dataList;

    public PageResult(){
        super();
    }

    public PageResult(Page page){
        super();
        this.current = page.current;
        this.pageSize = page.pageSize;
    }

    public PageResult(Page page, PageInfo info){
        super();
        this.current = page.current;
        this.pageSize = page.pageSize;
        this.total = info.getTotal();
        this.pages = info.getPages();
        this.setDataList(info.getList());
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

}
