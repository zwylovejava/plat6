package net.northking.cloudplatform.utils;


import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.exception.GlobalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ParamVerifyUtil {
	private final static Logger logger = LoggerFactory.getLogger(ParamVerifyUtil.class);
	/**
	 * 校验传入参数列表是否为Null或者为空字符串或者空的集合类型
	 * 如果存在为空的参数，则抛出异常
	 * 
	 * @param dataMap
	 * @param logger
	 * @param params
	 * @throws GlobalException
	 */
	public static void checkNullOrEmpty(Map<String, Object> dataMap, Logger logger, String ...params) {
		if (null != params && 0 != params.length) {
			for (String param: params) {
				Object obj = dataMap.get(param);
				if (null != obj && !"".equals(obj.toString())) {
					if (obj instanceof Collection) {
						final Collection<?> c = (Collection<?>) obj;
						if (!c.isEmpty()) {
							continue;
						}
					} else {
						continue;
					}
				}
				throw new GlobalException(ErrorConstants.CLT_SYS_PARAM_ERROR_CODE,param+ErrorConstants.CLT_SYS_PARAM_ERROR_MESSAGE);
		}

		}
	}
	

	/**
	 * 传入参数列表（String），判断这些参数是否为空，如果出现一个为空，则返回true
	 * @param arguments
	 * @return true表示出现为空的参数，false表示这些参数都不空
	 */
	public static boolean verifyNullString(String... arguments){
		
		boolean isValid = true;
		
		for(String arg : arguments){
			
			if(arg==null || "".equals(arg)){
				
				isValid = false;
				
				return !isValid;
				
			}
			
		}
		
		return !isValid;
	}
	
	/**
	 * 传入参数列表（Collection），判断这些参数是否为空，如果出现一个为空，则返回true
	 * @param arguments
	 * @return true表示出现为空的参数，false表示这些参数都不空
	 */
	public static boolean verifyNullCollection(Collection<?>... arguments){
		
		boolean isValid = true;
		
		for(Collection<?> col : arguments){
			
			if(col==null){
				
				isValid = false;
				
				return !isValid;
				
			}
			
		}
		
		return !isValid;
	}
	
	/**
	 * 检查Collection是否为空（即为null，或者size <= 0）。<br>
	 * 只要有一个为空则返回true。
	 * @param args Collection列表。
	 * @return true出现为空的参数。
	 */
	public static boolean verifyEmptyCollection(Collection<?> ... args ) {
		
		for (Collection<?> col : args) {
		
			if (null == col || col.size() <= 0)
				
				return true;
		}
		
		return false;
	}
	
	/**
	 * 判断是否为数据
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		
	    Pattern pattern = Pattern.compile("-1|[0-9]*"); 
	    
	    return pattern.matcher(str).matches();    
	    
	 }
	
	/**
	 * 判断是否有空数据
	 * @param list
	 * @return
	 */
	public static boolean verifyEmptyStringList(List<String> list){
		
		boolean flag = false ;

		if(null == list){
			
			return true ;
		}
		else{
			
			for(String str : list){
				
	    		if ( null == str || "".equals(str))
	    			
	    			return true;
			}
		}
		
		return flag ;
	}
}
