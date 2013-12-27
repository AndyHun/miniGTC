package com.gtc.test.security;

import java.security.MessageDigest;

/**
 * description
 * 单向加密(信息摘要)
 * MD5(Message-Digest Algorithm 5)
 *
 * author AndHun
 * Date: 12/27/13 5:08 PM
 * version 1.0
 */
public class oneWayEncrypt {
    public static void main(String[] args) throws Exception{
        String plainContent = "Test MD5";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //MessageDigest sha = MessageDigest.getInstance("SHA");
        md5.update(plainContent.getBytes());
        System.out.println("After MD5:"+new String(md5.digest()));
    }
}
