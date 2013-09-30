/*
 * PrivateKeyCryptographyGuide.java Sep 18, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @description  
 * @author AndyHun
 *
 * @Version 1.0
 */
public class PrivateKeyCryptographyGuide {
	
	public static void main(String[] args) throws Exception{
		byte[] plainText = "AndyHun".getBytes();
		
		//get DES private key
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		Key key = keyGenerator.generateKey();
		Key key2 = keyGenerator.generateKey();
		if(key.equals(key2)){
			System.out.println("will not get here, key not equals with key2");
		}
		
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(plainText);
		System.out.println(cipherText);
		
		//must use the prior key but not another one.
		cipher.init(Cipher.DECRYPT_MODE,key);
		byte[] plainResult = cipher.doFinal(cipherText);
		System.out.println(new String(plainResult));
	}
}
