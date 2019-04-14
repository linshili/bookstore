package com.nsc.web.test.mapper;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.nsc.web.util.DateTimeGenerator;

public class GeneralTest {

	//@Test
	public void test() {
		
		Date dateNow = DateTimeGenerator.getDateTime();
		System.out.println(dateNow.toString());
		
	}
	
	public void tettFastJson() {
		
	}

}
