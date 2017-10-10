package cn.mycloudedu.framework.core.utils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 
 * @author 尹前坤 2015 2 5
 *
 */
public class JsonBinder {
	
	private static Logger logger = LoggerFactory.getLogger(JsonBinder.class);
	private ObjectMapper mapper;
	
	public JsonBinder(Inclusion inclusion){
		mapper = new ObjectMapper();
	    mapper.setSerializationInclusion(inclusion);
	    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	}

    /**
     * 创建输出全部属性到Json字符串的Mapper;
     */
	public static JsonBinder buildNormalMapper(){
		return new JsonBinder(Inclusion.ALWAYS);
	}
	
	/**
	 * ����ֻ����ɿ����Ե�Json�ַ��Binder.
	 */
	public static JsonBinder buildNonNullBinder(){
		return new JsonBinder(Inclusion.NON_NULL);
	}
	
	/**
	 * ����ֻ�����ʼֵ���ı�����Ե�Json�ַ��Binder.
	 * @return
	 */
	public static JsonBinder buildNonDefaultBinder(){
		return new JsonBinder(Inclusion.NON_DEFAULT);
	}
	
	/** 
     * ���JSON�ַ�ΪNull��"null"�ַ�,����Null. 
     * ���JSON�ַ�Ϊ"[]",���ؿռ���. 
     *  
     * �����ȡ������List/Map,�Ҳ���List<String>���ּ�����ʱʹ���������: 
     * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {}); 
     */  
	
	public <T> T fromJson(String jsonString ,Class<T> clazz){
		if(StringUtils.isEmpty(jsonString)){
			return null;
		}
		
		try {
			return mapper.readValue(jsonString, clazz);
		}catch (IOException e) {
			logger.warn("parse json string error:"+jsonString,e);
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	public <T> T fromJson(String jsonString,JavaType javaType){
		if(StringUtils.isEmpty(jsonString)){
			return null;
		}
		try {
			return (T) mapper.readValue(jsonString,javaType);
		} catch (IOException e) {
			throw NestedException.wrap(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T fromJson(String jsonString,Class<?> parametrized,Class<?>...parameterClasses){
		return (T) this.fromJson(jsonString, constructParametricType(parametrized,parameterClasses));
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> fromJsonToList(String jsonString,Class<T> classMeta){
		return (List<T>) this.fromJson(jsonString, constructParametricType(List.class,classMeta));
	}

	@SuppressWarnings("unchecked")
	public <T> T fromJson(JsonNode node, Class<?> parametrized, Class<?>...parameterClasses){
		JavaType javaType = constructParametricType(parametrized, parameterClasses);
		try {
			return (T) mapper.readValue(node, javaType);
		} catch (IOException e) {
			throw NestedException.wrap(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T pathAtRoot(String json,String path,Class<?> parametrized,Class<?>...parameterClasses){
		JsonNode rootNode = parseNode(json);
		JsonNode node = rootNode.path(path);
		return (T) fromJson(node,parametrized,parameterClasses);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T pathAtRoot(String json,String path,Class<T> clazz){
		JsonNode rootNode = parseNode(json);
		JsonNode node = rootNode.path(path);
		return (T) fromJson(node,clazz);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T update(T object,String jsonString){
		try {
			return (T) mapper.readerForUpdating(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
			logger.warn("update json string:"+jsonString+"to object:"+object+"error.",e);
		} catch (IOException e) {
			logger.warn("update json string:"+jsonString+"to object:"+object+"error.",e);
		}
		return null;
	}
	
	/**
	 * �趨�Ƿ�ʹ��Enum��toString��������дEnum,
	 * Ϊfalseʱʹ��Enum��name()��������дEnum,Ĭ��Ϊfalse.
	 * ע�Ȿ����һ��Ҫ��Mapper���������еĶ�д����֮ǰ����
	 * @param value
	 */
	public void setEnumUseToString(boolean value){
		mapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, value);
		mapper.configure(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, value);
	}
	
	public ObjectMapper getMapper(){
		return mapper;
	}
	
	public JsonNode parseNode(String json){
		try {
			return mapper.readValue(json, JsonNode.class);
		} catch (IOException e) {
			throw NestedException.wrap(e);
		}
	}
	/**
	 * ���JSONP��ʽ���
	 * @param functionName
	 * @param object
	 * @return
	 */
	public String toJsonP(String functionName,Object object){
		return toJson(new JSONPObject(functionName, object));
	}
	
	/**
     * ���췺�͵�Type��List<MyBean>, �����constructParametricType(ArrayList.class,MyBean.class)
     *             Map<String,MyBean>�����(HashMap.class,String.class, MyBean.class)
     */ 
	public JavaType constructParametricType(Class<?> parametrized, Class<?>...parameterClasses){
		return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
	}
	
	
	
	public String toJson(Object object){
		try {
			return mapper.writeValueAsString(object);
		}  catch (IOException e) {
			logger.warn("write to json string error:"+object,e);
			return null;
		}
	}
	/**
	 * ���ȫ������
	 * @param object
	 * @return
	 */
	public static String toNormalJson(Object object){
		return new JsonBinder(Inclusion.ALWAYS).toJson(object);
	}
	/**
	 * ����ǿ�����
	 * @param object
	 * @return
	 */
	public static String toNonNullJson(Object object){
		return new JsonBinder(Inclusion.NON_NULL).toJson(object);
	}
	
	public static String toNonEmptyJson(Object object){
		return new JsonBinder(Inclusion.NON_EMPTY).toJson(object);
	}
	
	/**
	 * �����ʼֵ���ı䲿�ֵ�����
	 * @param object
	 * @return
	 */
	public static String toNonDefaultJson(Object object){
		return new JsonBinder(Inclusion.NON_DEFAULT).toJson(object);
	}
	
	/**
	 * ����ת���������͵�format pattern,�������Ĭ�ϴ�ӡ��
	 */
	
	public void setDateFormat(String pattern){
		if(StringUtils.isNotBlank(pattern)){
			DateFormat df = new SimpleDateFormat(pattern);
			mapper.setDateFormat(df);
		}
	}
	
	public static String toLogJson(Object object){
		JsonBinder jsonBinder = new JsonBinder(Inclusion.NON_EMPTY);
		jsonBinder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		return jsonBinder.toJson(object);
	}
}
