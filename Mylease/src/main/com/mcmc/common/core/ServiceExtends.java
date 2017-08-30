package com.mcmc.common.core;

import com.dywz.dao.ColumnDao;
import com.dywz.dao.NewsDao;
import com.dywz.dao.UserDao;

public class ServiceExtends {

	protected static NewsDao newsDao = new NewsDao();
	
	protected static ColumnDao columnDao = new ColumnDao();
	
	protected static UserDao userDao = new UserDao();
	
}
