/**
 * 
 */
package cn.mycloudedu.framework.core.utils;

import cn.mycloudedu.framework.core.exception.BusinessErrorCode;
import cn.mycloudedu.framework.core.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fu.Lj
 *
 * @version 2015年6月9日 下午3:10:27
 *
 */
public class DateUtil {

	public static final String HOUR_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";

	public static final String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";

	public static final String HOUR_MINUTE_SECOND_FORMAT = "HH:mm:ss";

    public static Date parser(String value)  {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (value==null||"".equals(value)){
                return null;
            }


        Date  date = null;
        try {
            date = simpleDateFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }
    public static String format(Date date){
        if (date==null){
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
	/**
	 * 日期转字符串
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}


	private static String dateToString(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * unixtime转字符串
	 * @param unixTime
	 * @return
	 */
	public static String unixTimeToString(long unixTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(unixTime * 1000L));
	}

	public static String unixTimeToString(long unixTime,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(unixTime*1000L));
	}

	/**
	 * 判断两个日期是否相差24小时
	 * @return
	 * @throws Exception
	 */
	public static boolean judgmentDate(String startTime, String endTime)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
		Date start = sdf.parse(startTime);
		Date end = sdf.parse(endTime);
		long cha = end.getTime() - start.getTime();
		if (cha < 0) {
			return false;
		}
		double result = cha * 1.0 / (1000 * 60 * 60);
		if (result <= 24) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * @author Cailin.Chen
	 * @Date 2015年7月2日
	 * @return 返回当前时间
	 */
	public static String getCurrentTime() {
		return dateToString(new Date());
	}
	public static String getCurrentTime(String format) {
		return dateToString(new Date(),format);
	}

	public static long getCurrentUnixTime() {
		return System.currentTimeMillis()/1000L;
	}

	public static long getTimeStamp() {
		return System.currentTimeMillis();
	}

	public static long dateToUnixTime(Date date) {
		return date.getTime()/1000L;
	}

	public static long stringToUnixTime(String dateStr) {
		Date date = parser(dateStr);
		return date.getTime()/1000L;
	}

	public static long stringToUnixTime(String dateStr,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			return 0;
		}
		return date.getTime()/1000;
	}

	/**
	 * 
	 * @param startTime
	 * @return
	 */
	public static String getEndDateStr(String startTime,int num) throws ParseException { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long time = df.parse(startTime).getTime();
		long day = num*24*60*60*1000L; 
		time+=day; 
		Date endDate = new Date(time);
		return df.format(endDate);
	 } 
	public static String getDuration(int durationSeconds){  
	    int hours = durationSeconds /(60*60);  
	    int leftSeconds = durationSeconds % (60*60);  
	    int minutes = leftSeconds / 60;  
	    int seconds = leftSeconds % 60;  
	      
	    StringBuffer sBuffer = new StringBuffer();  
	    if(hours!=0){
	    	sBuffer.append(addZeroPrefix(hours));  
	   	    sBuffer.append(":");  
	    }
	    sBuffer.append(addZeroPrefix(minutes));  
	    sBuffer.append(":");  
	    sBuffer.append(addZeroPrefix(seconds));  
	      
	    return sBuffer.toString();  
	}  
	  
	public static String addZeroPrefix(int number){  
	    if(number < 10){  
	        return "0"+number;  
	    }else{  
	        return ""+number;  
	    }  
	  
	}

	/**
	 *
	 * @param strDate
	 * @return
	 */
	public static Date dateFormat( String strDate) {
		if(StringUtils.isEmpty(strDate)){
			throw new IllegalArgumentException("时间不能为空");
		}
		String[] regexp = strDate.split(" ");
		String[] prefix = null;
		String[] suffix = null;
		int section = 0;
		if (regexp.length > 0){
			prefix = regexp[0].split("-");
		}
		if (regexp.length > 1){
			suffix = regexp[1].split(":");
		}
		if (null == prefix && null == suffix){
			throw new IllegalArgumentException("请输入有效时间数据");
		}

		section = prefix.length;

		if (null != suffix){
			section = section + suffix.length;
		}
		SimpleDateFormat dateFormat = null;
		switch (section){
			case 1:
				dateFormat = new SimpleDateFormat("yyyy");
				break;
			case 2:
				dateFormat = new SimpleDateFormat("yyyy-MM");
				break;
			case 3:
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				break;
			case 4:
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
				break;
			case 5:
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				break;
			case 6:
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				break;
		}
		if (null != dateFormat){
			try {
				return dateFormat.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 *
	 * @param date
	 * @return 大于是为1</br>等于是为0</br>小于是为-1</br>
	 */

	public static int compareWithCurrentTime(String date){
		return  compareWithCurrentTime(dateFormat(date));
	}

	/**
	 *
	 * @param dateStr
	 * @param fromat
	 * @return 大于是为1</br>等于是为0</br>小于是为-1</br>
	 */
	public static int compareWithCurrentTime(String dateStr,String fromat){
		SimpleDateFormat sdf = new SimpleDateFormat(fromat);
		Date compareDate =null;
		try {
			compareDate = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BusinessException(BusinessErrorCode.apply(BusinessErrorCode.DATE_FORMAT_ERROR()));
		}
		return compareWithCurrentTime(compareDate);
	}

	/**
	 *
	 * @param compareDate
	 * @return 大于是为1</br>等于是为0</br>小于是为-1</br>
	 */
	public static int compareWithCurrentTime(Date compareDate){
		if (null == compareDate){
			return -1;
		}
		Date currentDate = new Date();
		if (compareDate.getTime() > currentDate.getTime()){
			return 1;
		}else if(compareDate.getTime() == currentDate.getTime()){
			return 0;
		}else {
			return -1;
		}
	}

	public static int compareWithTime(String firstDateStr,String secondDateStr){
		Date firstDate = dateFormat(firstDateStr);
		Date secoendDate = dateFormat(secondDateStr);

		if (firstDate.getTime() > secoendDate.getTime()){
			return 1;
		}else if(firstDate.getTime() == secoendDate.getTime()){
			return 0;
		}else {
			return -1;
		}
	}
	public static int compareWithTime(String firstDateStr,String firstDateFormat,String secondDateStr,String secondDateFormat)
	throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat(firstDateFormat);
		Date firstDate = null;
		Date secoendDate = null;
		firstDate = sdf1.parse(firstDateStr);
		secoendDate = sdf1.parse(firstDateStr);

		if (firstDate.getTime() > secoendDate.getTime()){
			return 1;
		}else if(firstDate.getTime() == secoendDate.getTime()){
			return 0;
		}else {
			return -1;
		}
	}

    public static String getTimeStampString(Date date){
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
                .format(date));
        return now+"";
    }

    public static String getCurrentTimeStamp(){
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()));
        return now+"";
    }

    /**
	 * 秒转换成xx:xx:xx
	 */
	public static String secToTime(int time) {
		String timeStr = null;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0)
			return "00:00";
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				timeStr = unitFormat(0)+":"+unitFormat(minute) + ":" + unitFormat(second);
			} else {
				hour = minute / 60;
				if (hour > 99)
					return "99:59:59";
				minute = minute % 60;
				second = time - hour * 3600 - minute * 60;
				timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
			}
		}
		return timeStr;
	}

	public static String unitFormat(int i) {
		String retStr = null;
		if (i >= 0 && i < 10)
			retStr = "0" + Integer.toString(i);
		else
			retStr = "" + i;
		return retStr;
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.secToTime(3686));
	}
}
