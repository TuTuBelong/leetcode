package com.dao.zang;

import java.util.ArrayList;
import java.util.List;

public class ShowMeBug325 {
    public class ListNode {
        public int data;
        public ListNode next;
        public ListNode(){};
        public ListNode(int data){this.data=data;};
        public ListNode(int data, ListNode nxt){
            this.data = data;
            this.next = next;
        }
    }

    public boolean solution(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            list.add(node.data);
            node = node.next;
        }
        if(list.size()==1){
            return true;
        }
        int left = 0;
        int right = list.size()-1;
        while (right>left){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
