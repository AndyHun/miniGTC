package com.gtc.test.nio.buffer;

import java.nio.ByteBuffer;

/**
 * description
 * author AndHun
 * Date: 12/9/13 1:49 PM
 * version 1.0
 */
public class TestByteBuffer {
    public static void main(String[] args){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1);
        System.out.println(byteBuffer.isDirect());
    }
}
