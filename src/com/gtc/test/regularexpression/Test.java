/*
 * Test.java Nov 18, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @description  
 * @author AndyHun
 *
 * @Version 1.0
 */
public class Test {
	public static void main(String args[]){
		Pattern pattern = Pattern.compile("([0-9]{1,4})-([0-9]{1,4})-([0-9]{1,4})-([0-9]{1,4})-?([0-9]){0,4}");
		String content = "0-1-1-4-5";
		Matcher matcher =pattern.matcher(content);
		if(matcher.find()){
			System.out.println(matcher.group(5));
		}else{
			System.out.println("no");
		}
	}
}
