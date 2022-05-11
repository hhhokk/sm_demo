package sm_demo.demo.SM3_SM4;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * @author zy
 * @create 2022-05-11-22:53
 */
public class SM3_SM4Test {

    public static void main(String[] args)
    {
        String plainText = "这是一个测试字符串";

        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = "JeF8U9wHFOMfs2Y8";
        sm4.hexString = false;

        System.out.println("ECB模式");
        String cipherText = sm4.encryptData_ECB(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println();

        plainText = sm4.decryptData_ECB(cipherText);
        System.out.println("明文: " + plainText);
        System.out.println();

        System.out.println("CBC模式");
        sm4.iv = "JeF8U9wHFOMfs2Y8";
        cipherText = sm4.encryptData_CBC(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println();

        plainText = sm4.decryptData_CBC(cipherText);
        System.out.println("明文: " + plainText);

        byte[] md = new byte[32];
        byte[] msg1 = cipherText.getBytes();
        System.out.println(Util.byteToHex(msg1));
        SM3Digest sm3 = new SM3Digest();
        sm3.update(msg1, 0, msg1.length);
        sm3.doFinal(md, 0);
        String s = new String(Hex.encode(md));
        System.out.println(s);
    }
}
