package cn.mycloudedu.framework.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rupesh Chavan
 * @version 1.0
 *
 */
public class RegexUtil 
{
  /**
	 * @param email E Mail address
	 * @return boolean Flag demonstrating if it's a valid email
	 */
	public static boolean isEmail(String email)
	{	
		boolean isValid = false;
		
		String expression = "^[A-Za-z0-9]+([._\\\\-]*[A-Za-z0-9])*@([A-Za-z0-9]+[-A-Za-z0-9]*[A-Za-z0-9]+.){1,63}[A-Za-z0-9]+$";
		
		isValid = matchPattern(expression, email);
		
		return isValid;
	}

    public static boolean isMobile(String mobile){
        boolean isValid = false;

        String expression = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        isValid = matchPattern(expression,mobile);
        return isValid;
    }

	public static boolean isIdNo(String idno){
		boolean isValid = false;
		String expression = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
		isValid = matchPattern(expression,idno);
		return isValid;
	}

    public static boolean isUsername(String username){
        boolean isValid = false;
        String expression = "^[a-zA-Z\\u4e00-\\u9fa5_][a-zA-Z0-9\\u4e00-\\u9fa5_]+$";
        isValid = matchPattern(expression,username);
        return isValid;
    }
	public static boolean isStudno(String studno){
		boolean isValid = false;
		String expression = "^[^\\u4e00-\\u9fa5\\s]+$";
		isValid = matchPattern(expression,studno);
		return isValid;
	}


	/**
	 * @param uri URI/URL
	 * @return boolean Flag indicating if it's valid URI / URL
	 */
	public boolean isURI(String uri)
	{
		boolean isValid = false;
		String expression = "^(http|https|ftp)\\:\\/\\/(((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])|([a-zA-Z0-9_\\-\\.])+\\.(com|net|org|edu|int|mil|gov|arpa|biz|aero|name|coop|info|pro|museum|uk|me))((:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~])*)$";
		
		isValid = matchPattern(expression, uri);
		
		return isValid;
	}

	
	/**
	 * @param s Input string
	 * @return boolean Flag indicating if it's valid alpha numeric word
	 */
	public boolean isAlphaNumericWord(String s)
	{
		boolean isValid = false;
		String expression = "[A-Za-z0-9]+";
		
		isValid = matchPattern(expression, s);
		
		return isValid;
	}
	
	/**
	 * @param c Input character
	 * @return boolean Flag indicating if it's valid alpha numeric character
	 */
	public boolean isAlphaNumericCharacter(Character c)
	{
		boolean isValid = false;
		String expression = "[A-Za-z0-9]";
		
		isValid = matchPattern(expression, c.toString());
		
		return isValid;
	}
	
	/**
	 * @param s Input string
	 * @return boolean Flag indicating if it's valid alphabetic word 
	 */
	public boolean isAlphabeticWords(String s)
	{
		boolean isValid = false;
		String expression = "[a-zA-Z]+";
		
		isValid = matchPattern(expression, s);
		
		return isValid;
	}
	
	/**
	 * @param c Input character
	 * @return boolean Flag indicating if it's valid alphabetic character
	 */
	public boolean isAlphabeticCharacter(Character c)
	{
		boolean isValid = false;
		String expression = "[a-zA-Z]";
		
		isValid = matchPattern(expression, c.toString());
		
		return isValid;
	}
	
	/**
	 * @param number Input number
	 * @return boolean Flag indicating if it's valid hexadecimal number
	 */
	public boolean isHexadecimalNumber(int number)
	{
		boolean isValid = false;
		String expression = "[A-Fa-f0-9]+";
		
		isValid = matchPattern(expression, String.valueOf(number));
		
		return isValid;
	}
	
	/**
	 * @param number Input number
	 * @return boolean Flag indicating if it's valid octal number
	 */
	public boolean isOctalNumber(int number)
	{
		boolean isValid = false;
		String expression = "[0-7]+";
		
		isValid = matchPattern(expression, String.valueOf(number));
		
		return isValid;
	}
	
	/**
	 * @param number Input number
	 * @return boolean Flag indicating if it's valid integer number
	 */
	public static boolean isInteger(String number)
	{
		boolean isValid = false;
		String expression = "^([0-9]+)([0-9,]*)";
		
		isValid = matchPattern(expression, number);
		
		return isValid;
	}
	
	/**
	 * @param number Input number
	 * @return boolean Flag indicating if it's valid float number
	 */
	public static boolean isFloat(String number)
	{
		boolean isValid = false;
		String expression = "^([0-9]+)([\\d,]*).([0-9]+)";
		
		isValid = matchPattern(expression, number);
		
		return isValid;
	}
	
	/**
	 * @param s Input string
	 * @return boolean Flag indicating if it's valid string
	 */
	public static boolean isString(String s)
	{
		boolean isValid = false;
		String expression = "^[^<>`~!/@\\#}$%:;)(_^{&*=|'+]+$";
		
		isValid = matchPattern(expression, s);
		
		return isValid;
	}
	
	/**
	 * @param date Input date
	 * @return boolean Flag indicating if date is in a valid format
	 */
	public static boolean isDate(String date)
	{
		boolean isValid = false;
		String expression = "^([\\d]{4})([-:/])((0?[1-9])|((1)([0-2])))([-:/])((0?[1-9])|((1)[0-9])|((2)[0-9])|((3)[0-1]))$";
		
		isValid = matchPattern(expression, date);
		
		return isValid;
	}
	
	public static boolean matchPattern(String expression, String stringPattern)
	{
		boolean isValid = false;
		
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(stringPattern);
		
		if(matcher.matches())
		{
			isValid = true;
		}
		
		return isValid;
	}


}