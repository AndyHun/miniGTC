/*
 * MessageAuthenticationGuide.java Sep 16, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/**
 * @description  
 * @author AndyHun
 *
 * @Version 1.0
 */
public class MessageAuthenticationGuide {
	public static void main(String[] args){
		String message = "AndyHun";
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
			SecretKey md5Key = keyGen.generateKey();
			Mac mac = Mac.getInstance("HmacMD5");
			mac.init(md5Key);
			mac.update(message.getBytes());
			// output cryptographic provider
			System.out.println(mac.getProvider().getInfo());
			System.out.println(mac.doFinal());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
