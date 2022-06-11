package top.luobogan.fresh.binary;

import java.security.MessageDigest;

/**
 * Created by LuoboGan
 * Date:2022/5/11
 */
public class definationHAHA {

    public static void main(String[] args) throws Exception{
        // 4124bc0a9335c27f086f24ba207a4912     md5 在线校验
        // QSS8CpM1wn8IbyS6IHpJEg==             消息摘要使用的是16进制
        // 原文
        String input = "aa";
        // 算法
        String algorithm = "MD5";
        // 获取数字摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        // 消息数字摘要
        byte[] digest = messageDigest.digest(input.getBytes());
        for(byte dig : digest){
            System.out.print(dig+" ");
        }

//        System.out.println(new String(digest));
        // base64编码
//        System.out.println(Base64.encode(digest));
        // 创建对象用来拼接
        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {

            int c = b;
            int d = b & 0xff;

            // 转成 16进制
            String s = Integer.toHexString(c);
            //System.out.println(s);
            if (s.length() == 1){
                // 如果生成的字符只有一个，前面补0
                s = "0"+s;
            }
            sb.append(s);
        }
        System.out.println(sb.toString());

        System.out.println("4124bc0a9335c27f086f24ba207a4912".length());

    }

}
