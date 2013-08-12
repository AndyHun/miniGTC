/*
 * TestSocket.java Aug 12, 2013
 * 
 * Copyright 2013 General TECH , Inc. All rights reserved.
 */
package com.gtc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description
 * @author AndyHun
 * 
 * @Version 1.0
 */
public class TestSocket {

	public static void main(String[] args) throws Exception {
		//Socket socket = new Socket("127.0.0.1", 8080);
		Socket socket = new Socket("www.baidu.com",80);
		boolean autoflush = true;
		PrintWriter out = new PrintWriter(socket.getOutputStream(), autoflush);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// Send request
		/*out.println("GET /fireday/ HTTP/1.1");
		out.println("Host: localhost:8080");
		out.println("Connection: Close");*/
		out.println("GET / HTTP/1.1");
		out.println("Host: www.baidu.com:80");
		out.println("Connection: Close");
		out.println();

		// read the response
		boolean loop = true;
		StringBuffer sb = new StringBuffer();
		while (loop) {
			if (in.ready()) {
				int i = 0;
				while (i != -1) {
					i = in.read();
					sb.append((char) i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
		}
		
		//Display the response to the out console
		System.out.println(sb.toString());
		socket.close();

	}
}
