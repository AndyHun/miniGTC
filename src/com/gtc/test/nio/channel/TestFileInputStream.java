package com.gtc.test.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * description
 * author AndHun
 * Date: 12/9/13 3:52 PM
 * version 1.0
 */
public class TestFileInputStream {
    private static final String FILE_PATH = "D:\\IDEAWorkSpace\\GTC\\miniGTC\\readme.md";
    private static final String DEST_PATH = "D:\\test.txt";

    public static void wrongWrite() throws Exception{
       ByteBuffer buffer = ByteBuffer.allocate(10);

       FileInputStream input = new FileInputStream(FILE_PATH);
       FileChannel fileChannel = input.getChannel();
       //exception for read-only
       fileChannel.write(buffer);
    }

    public static void copyFile()throws Exception{
        File file = new File(FILE_PATH);
        ByteBuffer buffer = ByteBuffer.allocate(16*16);

        //get input fileChannel
        FileInputStream input = new FileInputStream(file);
        FileChannel inputChannel = input.getChannel();

        //get output fileChannel
        FileOutputStream output = new FileOutputStream(DEST_PATH);
        FileChannel outputChannel = output.getChannel();

        while(inputChannel.read(buffer)!=-1){
            buffer.flip();//need to flip first
            while(buffer.hasRemaining()){
                outputChannel.write(buffer);
            }
            buffer.clear();
        }
        if(inputChannel.isOpen()){
            inputChannel.close();
        }
        if(outputChannel.isOpen()){
            outputChannel.close();
        }
    }


    public static void main(String[] args) throws Exception{
        //TestFileInputStream.wrongWrite();
        TestFileInputStream.copyFile();
    }
}
