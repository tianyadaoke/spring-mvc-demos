package leetcode;

import org.junit.jupiter.api.Test;

public class Test21 {
    @Test
    void mergeTwoLists() {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
        if(l1.next!=null){

        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
