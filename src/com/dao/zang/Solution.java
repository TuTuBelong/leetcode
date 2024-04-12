package com.dao.zang;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    //龟兔赛跑,字节一面
    public static int floydRabbit(int[] a) {
        int res = 0;
        int fast, slow;
        fast = slow = 0;
        do {
            fast = a[a[fast]];
            slow = a[slow];
        } while (fast != slow);
        slow = 0;
        do {
            fast = a[fast];
            slow = a[slow];
        } while (fast != slow);
        res = slow;
        return res;
    }

    //121.股票
    public static int profit121(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    //动态规划硬币问题
    public static int coinNum(int[] A, int M) {
        int[] f = new int[M + 1];
        int n = A.length;
        f[0] = 0;
        for (int i = 1; i <= M; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i - A[j]] + 1, f[i]);
                }
            }
        }
        if (f[M] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[M];
    }


    //机器人寻路方式
    public static int uniquePath(int m, int n) {
        int[][] f = new int[m][n];
        int i, j;
        for (i = 0; i < m; ++i) {
            for (j = 0; j < n; ++j) {
                if (i == 0 | j == 0) {
                    f[i][j] = 1;
                }else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m][n];
    }

    //环形数组最大和部分
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int dpmin[] = new int[n];
        dp[0] = nums[0];
        int sum = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(dp[i], max);
            dpmin[i] = Math.min(nums[i], nums[i] + dpmin[i - 1]);
            min = Math.min(dpmin[i], min);
        }
        for (int i : dp
        ) {
            System.out.println("op" + i);
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);
        return Math.max(max, sum - min);
    }

    public int numJewelsInStones(String jewels, String stones) {
        char[] jewel = jewels.toCharArray();
        int k = 0;
        for (int i = 0; i < jewel.length; i++) {
            //if(stones.indexOf(jewel[i])>=0) k++;
            for (int j = 0; j < stones.length(); j++) {
                if (stones.charAt(j) == jewel[i]) {
                    k++;
                }
            }
        }
        return k;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (i == j) continue;
                answer[j] = answer[j] * nums[i];
            }
        }
        return answer;
    }

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num < mid) {
                mid = num;
            } else if (num > mid) {
                return true;

            }
        }
        return false;
    }


     class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode();
            ListNode cur = l3;
            int carry = 0;
            while(l1!=null|l2 != null|carry!=0){
                if(l1!=null) carry+=l1.val;
                if(l2!=null) carry+=l2.val;
                cur=cur.next=new ListNode(carry%10);
                carry/=10;
                if(l1!=null) l1=l1.next;
                if(l2!=null) l2=l2.next;

            }
            return l3.next;
        }
//思路错误
        public int lengthOfLongestSubstring(String s) {
            if (s.equals("")){
                return 1;
            }
            int max = 0;
            Set<Character> set =new HashSet<>();
            for(int i =0;i<s.length();i++){
                if(!set.contains(String.valueOf(s.charAt(i)))){
                    set.add(s.charAt(i));
                }else{
                    if(set.size()>max) {
                        max = set.size();
                    }
                    set.clear();
                    set.add(s.charAt(i));
                }

            }
            return max;
        }

        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            int n = s.length();
            int k = n-1;
            for (int i = 0;i < n/2;i++){
                if (s.charAt(i)!=s.charAt(k)){
                    return false;
                }
                k--;
            }
            return true;
        }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length+nums2.length;
        int [] a=new int[n];
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(nums2.length==0){
                a[i]=nums1[j];
                j++;
                continue;
            }
            if(k>0 && k==nums2.length){
                k=k-1;
            }
            if(j<nums1.length && nums1[j]<=nums2[k]){
                a[i]=nums1[j];
                j++;
            }else if(k<nums2.length){
                a[i]=nums2[k];
                k++;
            }
        }
        if(n%2==0){
            double b=(a[n/2]*1.0+a[(n/2)-1])/2;
            return b;
        }else{
            return a[(n-1)/2];
        }
    }
    public static int maxProduct(int[] nums){
        int ans=nums[0];
        int l=0,r=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]<0){
                int tem=l;l=r;r=tem;
            }
            l= Math.max(l*nums[i],nums[i]);
            r= Math.min(r*nums[i],nums[i]);
            ans=Math.max(ans,l);
        }
        return ans;
    }
    public String filterAndOrder (String enterString) {
        // write code here
        String high = "eatonsir";
        String middle = "hdlumcfgpw";
        String low = "ybvqkjxz";
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        StringBuilder c = new StringBuilder();
        int j = enterString.length();
        for(int i =0;i<j;i++){
            if(high.indexOf(enterString.charAt(i))>=0){
                a.append(enterString.charAt(i));
            } else if (middle.indexOf(enterString.charAt(i))>=0) {
                b.append(enterString.charAt(i));
            } else {
                c.append(enterString.charAt(i));
            }
        }
        a.append(' ');
        b.append(' ');
        a.append(b);
        a.append(c);
        return a.toString();
    }
}
