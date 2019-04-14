package com.nsc.web.test.mapper;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.nsc.backend.mapper.CartMapper;
import com.nsc.backend.mapper.ChangeMapper;
import com.nsc.web.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml", "classpath:config/*.xml" })
@WebAppConfiguration
public class BookMapperTest {
	
	public static final String classname = "BookMapperTest";

	@Resource
	private ChangeMapper changeMapper;
	
	@Test
	public void testBookNovel() {
		try {
			changeMapper.cNovel(7, 0, 2);
		}catch(Exception e) {
			LogUtil.out(classname, "testBookNovel", "exec-->"+e.toString());
		}
	}

}
