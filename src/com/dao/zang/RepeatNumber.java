package com.dao.zang;

import java.util.ArrayList;
import java.util.HashMap;

public class RepeatNumber {

    public static boolean isSubsequence (String S, String T) {
        int l1 = S.length();
        int l2 = T.length();
        int p1=0;
        int p2=0;
        for(int i=0;i<l1;i++){
            for(int j = p2;j<l2;j++){
                if(T.charAt(j)== S.charAt(i)){
                    p2++;
                    break;
                }

            }
            p1++;
        }
        if(p1==l1) {
            System.out.println(p1);
            // write code here
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String S = "nowef";
        String T = "nowcoder";
        isSubsequence(S,T);
    }
}





