package com.mcmc.common.core;

import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExpandBeanListHandler<T> extends BeanListHandler<T> {

	private static final RowProcessor CONVERT=new BasicRowProcessor(new ExpandBeanProcessor(new HumpMatcher()));

	public ExpandBeanListHandler(Class<T> type) {
		super(type,CONVERT);
	}
}
