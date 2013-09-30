/*
 * SerializedUtil.java Sep 24, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description  
 * @author AndyHun
 *
 * @Version 1.0
 */
public class SerializedUtil {
	
	public static void write(String filePath, Object object) throws Exception{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
		objectOutputStream.writeObject(object);
	}
	
	public static Object read(String filePath) throws Exception{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
		return objectInputStream.readObject();
	}
}
