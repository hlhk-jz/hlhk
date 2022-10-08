package cn.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static void main(String[] args){
        String str = "{\"param1\":\"value1\" ,\"param2\":\"value2\" ，\"param3\":\"value3\"}noxxxxx20170721132452".replaceAll("[ \t\r\n]","");

        String md5 = getMD5(str);
        String[] split = md5.split("");
        System.out.println("转换为十六进制：\n"+split);


    }
    private static String hexString="0123456789ABCDEF";
    /**
     *
     * @param bytes
     * @return 将二进制转换为十六进制字符输出
     */
    public static String BinaryToHexString(byte[] bytes){

        String result = "";
        String hex = "";
        for(int i=0;i<bytes.length;i++){
            //字节高4位
            hex = String.valueOf(hexString.charAt((bytes[i]&0xF0)>>4));
            //字节低4位
            hex += String.valueOf(hexString.charAt(bytes[i]&0x0F));
            result +=hex+" ";
        }
        return result;
    }


    private static String toHex(byte[] result) {


        StringBuffer sb = new StringBuffer(result.length * 2);

        for (int i = 0; i < result.length; i++) {


            sb.append(Character.forDigit((result[i] & 240) >> 4, 16));

            sb.append(Character.forDigit(result[i] & 15, 16));

        }

        return sb.toString();

    }

    /*
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String encode(String str)
    {
//根据默认编码获取字节数组
        byte[] bytes=str.getBytes();
        StringBuilder sb=new StringBuilder(bytes.length*2);
//将字节数组中每个字节拆解成2位16进制整数
        for(int i=0;i<bytes.length;i++)
        {
            sb.append(hexString.charAt((bytes[i]&0xf0)>>4));
            sb.append(hexString.charAt((bytes[i]&0x0f)>>0));
        }
        return sb.toString();
    }
    /**
     * 16进制转换成为string类型字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * MD5加密字符串
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        if (!StringUtils.isEmpty(str)) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                byte b[] = md.digest();
                int i;
                StringBuffer buf = new StringBuffer("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                return buf.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
