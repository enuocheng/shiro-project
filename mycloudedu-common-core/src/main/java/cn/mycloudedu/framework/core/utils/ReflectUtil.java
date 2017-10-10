package cn.mycloudedu.framework.core.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 乾坤 on 2016/6/20.
 */
public class ReflectUtil {

    public static List<Field> getAllField(Class clazz){
        List<Field> classFields = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        classFields.addAll(Arrays.asList(fields));
        if (!clazz.getSuperclass().equals(Object.class)){
            getSuperClassField(clazz.getSuperclass(),classFields);
        }
        return classFields;
    }

    private static void getSuperClassField(Class clazz,List<Field> classFields){
        Field[] fields = clazz.getDeclaredFields();
        classFields.addAll(Arrays.asList(fields));
        if (!clazz.getSuperclass().equals(Object.class)){
            getSuperClassField(clazz.getSuperclass(),classFields);
        }
    }
}
