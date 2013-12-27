package com.gtc.test.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * description
 * 对称加密算法支持:
 * DES、DESede、AES、
 * author AndHun
 * Date: 12/27/13 4:27 PM
 * version 1.0
 */
public class SymmetricEncrypt {
    private KeyGenerator keyGenerator;

    //密钥
    private SecretKey secretKey;

    //加密器
    private Cipher cipher;

    public SymmetricEncrypt() throws Exception{
        //获取对应算法的密钥
        keyGenerator = KeyGenerator.getInstance("DES");
        secretKey = keyGenerator.generateKey();
        //获取对应算法的加密器
        cipher = Cipher.getInstance("DES");
    }

    public byte[] encrypt(byte[] plainContent) throws Exception{
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainContent);
    }

    public byte[] decrypt(byte[] cipherContent) throws Exception{
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(cipherContent);
    }

    public static void main(String[] args) throws Exception{
        SymmetricEncrypt symmetricEncrypt = new SymmetricEncrypt();
        byte[] encryptContent = symmetricEncrypt.encrypt("Hello Test symmetric encrypt".getBytes());
        System.out.println("After Encrypt:" + new String(encryptContent.toString()));
        System.out.println("After Decrypt:" + new String(symmetricEncrypt.decrypt(encryptContent)));
    }


}
