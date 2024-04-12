package solution;

import java.util.HashMap;

public class Solution {
    public String unDumplateSubstring (String enterString) {
        // write code here
        int k=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int j = enterString.length();
        for(int i = 0; i<j; i++) {
            if(!map.containsKey(enterString.charAt(i))){
                k++;
                map.put(enterString.charAt(i),k);
            }
        }
        StringBuilder s = new StringBuilder();
        map.forEach((key,value)->{
            s.append(key);
        });
        s.append(k);
        return s.toString();
    }
}
