package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Component;

/* 메모리 할당 
 * @Component, 
 * @Repository, 
 * @Service, 
 * @Controller, 
 * @RestController, 
 * @ControllerAdvice, 
 */

/*<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
p:driverClassName="oracle.jdbc.driver.OracleDriver"
p:url="jdbc:oracle:thin:@localhost:1521:XE"
p:username="hr"
p:password="happy"
p:maxActive="20"
p:maxIdle="10"
p:maxWait="-1"
></bean>*/

@Component("ds")
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource(){
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
		setMaxActive(20);
		setMaxIdle(10);
		setMaxWait(-1);
	}
}
