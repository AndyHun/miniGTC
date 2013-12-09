package com.gtc.test.nio.buffer;

import java.nio.ByteOrder;

/**
 * description The endian of current JVM.
 * author AndHun
 * Date: 12/9/13 11:10 AM
 * version 1.0
 */
public class TestByteOrder {
    public static void main(String[] args){
        System.out.println(ByteOrder.nativeOrder());
    }
}
