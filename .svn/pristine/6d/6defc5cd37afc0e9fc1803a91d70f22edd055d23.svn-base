package cn.mycloudedu.framework.core.result;

import java.io.Serializable;

/**
 * Created by 乾坤 on 2016/6/20.
 */
public class Page implements Serializable{
    protected   int current=1;//当前页

    protected   int pageSize=10;

    public Page(){}

    public Page(int pageSize){
        this(1,pageSize);
    }
    public Page(int current, int pageSize){
        setCurrent(current);
        setPageSize(pageSize);
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >0) {
            this.current = current;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
