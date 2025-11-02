package com.dao.zang;

import java.util.HashMap;
import java.util.Scanner;

public class Cost {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            // 测试合并
            int n = in.nextInt();
            int k = in.nextInt();
            int min = 1000000000;
            int p = 0;
            int max = 0;
            int temp = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            while (n>0){
                int x = in.nextInt();
                if(x<min){
                    min=x;
                }
                if(x>p){
                    p=x;
                }
                int y = in.nextInt();
                map.put(x,y);
                n--;
            }
            System.out.println(min);
            while ( min< p) {
                for(int j = min;j<min+k;j++){
                    if(map.containsKey(j)){
                        temp = map.get(j)+temp;
                        System.out.println(temp);
                    }
                }
                if(max<temp){
                    max = temp;
                    temp = 0;
                    System.out.println(max);
                }
                min+=1;
            }
            System.out.println(max);
        }

}
