package com.livedoor.flow_manager.IConstant;

/**
 * Global constants variable for FX System.
 * @author Roger Sun <roger@bestwiz.cn>
 * 
 * @copyright 2006, BestWiz(Dalian) Co.,Ltd
 * @version $Id: SystemConstants.java,v 1.2 2008/06/19 03:47:53 panxy Exp $
 */
public interface SystemConstants {
	
	/**
	 * 配置文件路径的 键名，通常为 configPath，整个程序不用更改。
	 * java -DconfigPath
	 */
	public static final String CONFIG_PATH_KEY = "configPath";
	
	
	/**
	 * ehcache query cache的前缀，在ehcache.xml中，querycache中名称总是
	 * 定义的形式如下：
	 * CacheRegion.cn.bestwiz.jhf.component.dao.bean.main.FxCurrencyPair
	 * 
	 * 程序中如果query CachedClass, 总是如下使用。
	 * Query   query =s.CreateQuery( hql) ;
	 * query.setCacheable(true);  
     * query.setCacheRegion(SystemConstants.QUERY_CACHE_PREFIX+CachedClass.class.getName());
     * query.list() ;
	 */
	public static final String QUERY_CACHE_PREFIX = "CacheRegion.";
	
    /**
     * 从shell文件中取得进程名PROCESS_NAME
     * 在shell中是通过java -DPROCESS_NAME= xxxx 设置的,
     * 程序中是通过System.getProperty(SystemConstants.PROCESS_NAME)获取的
     */
    public static final String PROCESS_NAME = "PROCESS_NAME";
    
    
    /**
     * idgenerate 是否接受jms 消息模式 true 接受, false 不接受, 默认接受
     */
    public static final String UIDG_JMS_REC_MODE = "UIDG_JMS_REC_MODE";
}
