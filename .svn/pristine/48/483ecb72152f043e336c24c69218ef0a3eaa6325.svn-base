package cn.mycloudedu.framework.core.utils;

public class NestedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7739920267939175380L;
	
	private Throwable throwable;
	
	private NestedException(Throwable t){
		this.throwable = t;
	}
	
	public static RuntimeException wrap(Throwable t){
		if(t instanceof RuntimeException){
			return (RuntimeException) t;
		}
		return new NestedException(t);
	}
   public Throwable getCause(){
	   return this.throwable;
   }
   
   public void printStackTrace(){
	   this.throwable.printStackTrace();
   }
}
