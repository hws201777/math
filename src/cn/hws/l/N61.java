package cn.hws.l;

public class N61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k ==0 || head.next == null) return head;
        ListNode result = null;
        int length = 0;
        ListNode tmp = head;
        int tmpindex = 0;
        while(tmp != null){
            tmp = tmp.next;
            length++;

            if(length == k){
                tmpindex = length;
                break;
            }
        }

        ListNode fast = head;
        ListNode slow = head;

        k = k%length;
        if(k == 0) return head;

        while(k != 0){
            fast = fast.next;
            k--;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        result = slow.next;
        slow.next = null;

        return result;

    }
}
