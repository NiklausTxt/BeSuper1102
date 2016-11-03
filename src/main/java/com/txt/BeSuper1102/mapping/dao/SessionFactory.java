package com.txt.BeSuper1102.mapping.dao;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.txt.BeSuper1102.TestMain;

public class SessionFactory {
	private static SqlSessionFactory sessionFactory = null;
	
	private SessionFactory(){}
	
	public synchronized static SqlSessionFactory getInstance(){
		if(sessionFactory == null){
			String resource = "mybatis_conf.xml";
			InputStream is = TestMain.class.getClassLoader().getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		return sessionFactory;
	}
}
