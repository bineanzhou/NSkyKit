package com.nsky.kit.util;

/**
 * Created by zhoubin on 2019/1/17.
 **/
public class Byte2HexUtil {
    public static void byte2hex(byte b, StringBuffer buf) {
        char[] hexChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int high = (b & 240) >> 4;
        int low = b & 15;
        buf.append(hexChars[high]);
        buf.append(hexChars[low]);
    }

    public static String toHexString(byte[] block) {
        StringBuffer buf = new StringBuffer();
        int len = block.length;

        for(int i = 0; i < len; ++i) {
            byte2hex(block[i], buf);
            if (i < len - 1) {
                ;
            }
        }

        return buf.toString();
    }

}
