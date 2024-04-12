package com.dao.zang;

public class MergeString {
    public char getChar(int number){
        String s="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char ch=1;
        if(number<25){
            ch=s.charAt(number);
        }
        return ch;
    }
    /**
     * @param columnNumber 整型
     * @return 字符串
     */
    public String solution(int columnNumber) {
        // 在这里写代码
        StringBuffer sb=new StringBuffer();
        while(columnNumber>0){
            sb.insert(0,getChar(columnNumber%26));
            columnNumber=columnNumber/26;
        }

        return sb.toString();
    }

}
