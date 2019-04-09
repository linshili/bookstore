package com.nsc.web.test.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nsc.backend.entity.Book;
import com.nsc.backend.mapper.ChangeMapper;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:application-context.xml", "classpath:config/*.xml" })
//@WebAppConfiguration
public class ChangeMapperTest {

	// mybatis配置文件
	private String resource;
	private InputStream inputStream;
	// 创建会话工厂
	private SqlSessionFactory sqlSessionFactory;
	// 通过工厂得到SqlSession
	private SqlSession sqlSession;
	private Configuration configuration;

	@Resource
	private ChangeMapper changeMapper;

	@Before
	public void beforeTest() throws IOException {

//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/bookstore?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
//		String username = "root";
//		String password = "root";
//		DataSource dataSource = new PooledDataSource(driver, url, username, password);
//		// 创建事务
//		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		Environment environment = new Environment("development", transactionFactory, dataSource);
//		configuration = new Configuration(environment);
//		configuration.addMappers("com.nsc.backend.mapper");
//
//		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//		sqlSession = sqlSessionFactory.openSession();

	}

	// @Test
	public void testChangeMapperBaseProgram() {

		Map<String, Integer> prms = new HashMap<String, Integer>();
		prms.put("start", 0);
		prms.put("end", 2);
		
		List<Book> bookList = sqlSession.selectList("com.nsc.backend.mapper.ChangeMapper.cBestSellingMap", prms);
		System.out.println("");
		System.out.println(bookList);
	}

	 @Test
	public void testChangeMapper() {

		List<Book> bookList = changeMapper.cBestSelling(0, 2);

		System.out.println(bookList);
	}

	@After
	public void afterTest() {
		sqlSession.close();
	}

}
