package cn.mycloudedu.framework.core.result;

import cn.mycloudedu.framework.core.annotations.OrderProperty;
import cn.mycloudedu.framework.core.exception.BusinessException;
import cn.mycloudedu.framework.core.exception.SystemErrorCode;
import cn.mycloudedu.framework.core.utils.CamelCaseUtils;
import cn.mycloudedu.framework.core.utils.ReflectUtil;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by 乾坤 on 2016/6/20.
 */
public class PageOrder extends Page {
    private String property="";
    private String direction = "";

    private String defaultProperty;

    private String defaultDirection;

    public void setDefaultPropertyDirection(@NotNull String property, String direction){
        if ("".equals(this.property)){
            this.property = property;
            this.direction = direction;
        }
        this.defaultProperty = property;
        this.defaultDirection = direction;
    }

    public String getDirection() {
        if (this.checkDirection()) {
            return direction;
        }else {
            throw new BusinessException(SystemErrorCode.apply(SystemErrorCode.ORDER_DIRECTION_ERROR()));
        }
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isProperty(@NotNull Class clazz){
        List<Field> fields = ReflectUtil.getAllField(clazz);
        for (Field field:fields){
            if(field.isAnnotationPresent(OrderProperty.class)) {
                if (field.getName().equals(this.property)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDirection(){
        if ("".equals(this.direction)||"desc".equalsIgnoreCase(this.direction)||"asc".equalsIgnoreCase(this.direction)){
            return true;
        }
        return false;
    }

    public String getOrderBy(@NotNull Class clazz){
        String orderBy = "";
        if (!"".equals(property)) {
            String property = this.getProperty(clazz);
            orderBy = property+ " " + this.getDirection();
        }
        return orderBy.trim();
    }

    public String getProperty(@NotNull Class clazz) {
            if (this.isProperty(clazz)) {
                return CamelCaseUtils.toUnderlineName(property);
            } else {
                throw new BusinessException(SystemErrorCode.apply(SystemErrorCode.ORDER_PROPERTY_ERROR()));
            }
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
