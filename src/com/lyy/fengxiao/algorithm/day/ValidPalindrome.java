package com.lyy.fengxiao.algorithm.day;

public class ValidPalindrome {

    /**
     * 680. 验证回文字符串 Ⅱ
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 示例 1:
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * 注意:
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     *
     * 解题思路：双端指针
     */
    public static boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j){
            boolean flag1=true;
            boolean flag2=true;
            if (s.charAt(i)!=s.charAt(j)) {
                //删除i位置上的元素，判断i+1到j的字符串是否是回文
                int m=i,n=j;
                while (m<n){
                    m++;
                    if (s.charAt(m)!=s.charAt(n)){
                        flag1=false;
                        break;
                    }
                    n--;
                }

                //删除j上的元素，判断i到j-1的字符串是否是回文
                m=i;
                n=j;
                while (m<n){
                    n--;
                    if (s.charAt(m)!=s.charAt(n)){
                        flag2=false;
                        break;
                    }
                    m++;
                }

                return flag1 || flag2;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s="abc";
        System.out.println(validPalindrome(s));
    }
}
