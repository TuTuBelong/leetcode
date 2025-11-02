package com.dao.zang;

import java.util.HashSet;

public class GetBookListNumber {
    //求出不同的书的个数
    public static int getBookNum(char[] books){
        HashSet<String> set=new HashSet<>();
        for (int i = 0; i < books.length; i++) {
            set.add(String.valueOf(books[i]));
        }
        return set.size();
    }
    //对不同的书进行排列组合计算
    public int getCombineBooksNum(int n){
        int num=0;
        for (int i = 1; i < n+1; i++) {
           num+=combine(n,i);
        }
        return num;
    }
    public int combine(int n,int i){
        return 1;
    }

    public static void main(String[] args) {
        char[] books={'a','b','c','a'};
        System.out.println(GetBookListNumber.getBookNum(books));
    }
}
