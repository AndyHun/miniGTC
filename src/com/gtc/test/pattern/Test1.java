/*
 * Test1.java Oct 16, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description  
 * @author AndyHun
 *
 * @Version 1.0
 */
public class Test1 {
	public static void main(String[] args){
		String input = "$260 Plan covers 90 days each benefit period.For Medicare-covered hospital stays:- Days 1 - 7:   copay per day- Days 8 - 90";
        Pattern pattern = Pattern.compile("\\$\\d");
        Matcher matcher = pattern.matcher(input);
        
        StringBuffer buffer = new StringBuffer();
        while(matcher.find()) {
        matcher.appendReplacement(buffer, "<b>" + matcher.group() + "</b>");
        //matcher.appendReplacement(buffer, "<b>//" + matcher.group() + "</b>");
        }
        matcher.appendTail(buffer);
        System.out.println(buffer.toString());
	}
}
