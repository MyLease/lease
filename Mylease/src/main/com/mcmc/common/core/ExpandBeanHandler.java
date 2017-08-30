package com.mcmc.common.core;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.expand.ExpandBeanProcessor;
import org.apache.commons.dbutils.expand.HumpMatcher;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 
 * @author UncleDrew
 * @Title ExpandBeanHandler.java
 * @Description 驼峰命名匹配
 * @time 2017年5月16日 下午9:51:23
 */
public class ExpandBeanHandler<T> extends BeanHandler<T> {

	private static  final RowProcessor CONVERT=new BasicRowProcessor(new ExpandBeanProcessor(new HumpMatcher()));
	
	public ExpandBeanHandler(Class<T> type) {
		super(type,CONVERT);
	}
}
