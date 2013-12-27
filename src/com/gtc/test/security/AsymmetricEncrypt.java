package com.gtc.test.security;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * description
 * author AndHun
 * Date: 12/27/13 4:47 PM
 * version 1.0
 */
public class AsymmetricEncrypt {

    private KeyPairGenerator keyPairGenerator;

    private RSAPrivateKey rsaPrivateKey;

    private RSAPublicKey rsaPublicKey;

    private Cipher cipher;

    public AsymmetricEncrypt() throws Exception {
        //获取密钥生成器
        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //初始化密钥长度
        keyPairGenerator.initialize(1024);
        //获取密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取私钥
        rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        //获取公钥
        rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        //获取对应加密器
        cipher = Cipher.getInstance("RSA");
    }

    public byte[] encryptRsa(byte[] plainContent) throws Exception {
        //初始化加密器的工作模式
        cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
        return cipher.doFinal(plainContent);
    }

    public byte[] decryptRsa(byte[] encryptContent) throws Exception {
        //初始化加密器的工作模式
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
        return cipher.doFinal(encryptContent);
    }

    public static void main(String[] args) throws Exception {
        AsymmetricEncrypt asymmetricEncrypt = new AsymmetricEncrypt();
        byte[] encryptContent = asymmetricEncrypt.encryptRsa("Hello Test AsymmetricEncrypt".getBytes());
        System.out.println("After encrypt:" + new String(encryptContent));
        System.out.println("After decrypt:" + new String(asymmetricEncrypt.decryptRsa(encryptContent)));
    }
}
