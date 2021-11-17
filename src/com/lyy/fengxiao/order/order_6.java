package com.lyy.fengxiao.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 白榆
 * @Date: 2021/7/5 3:12 下午
 */
public class order_6 {

    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        int numRows=4;
        System.out.println(convert(s,numRows));
        System.out.println(convert1(s,numRows));
        System.out.println(convert1(s,numRows).equals(convert(s,numRows)));
    }

    public static String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        int raw = 0;
        int cell = 0;
        boolean flag = false;
        char[][] word = new char[numRows][s.length()];
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (raw == 0) {
                flag = false;
            } else if (raw == numRows - 1) {
                flag = true;
            }
            if (raw < numRows) {
                word[raw][cell] = c;
                if (!flag) {
                    raw++;
                } else {
                    raw--;
                    cell++;
                }
            }
        }

        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (word[i][j]!=0){
                    builder.append(word[i][j]);
                }
            }
        }
        return builder.toString();
    }

    public static String convert1(String s, int numRows){
        if (numRows==1){
            return s;
        }
        List<StringBuilder> builders=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            builders.add(new StringBuilder());
        }
        int raw=0;
        int flag=-1;
        for (int i = 0; i < s.length(); i++) {
            if (raw==0 || raw==numRows-1){
                flag=-flag;
            }
            final char c = s.charAt(i);
            builders.get(raw).append(c);
            raw+=flag;
        }
        StringBuilder result=new StringBuilder();
        for (StringBuilder builder : builders) {
            result.append(builder.toString());
        }
        return result.toString();
    }
}
