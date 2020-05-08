package com.sist.dao;

import javax.annotation.Resource;
import javax.inject.Qualifier;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;


@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{
	
//	@Autowired
//	@Qualifier("ds")

//	@Resource(name="ds")
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
	public MySqlSessionFactoryBean()
	{
		try {
			//class 충돌로 패키지 이름을 주어서 구분할 수 있다.
			org.springframework.core.io.Resource res = new ClassPathResource("Config.xml");
			//java.util.Date date = new java.util.Date();
			
			setConfigLocation(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
