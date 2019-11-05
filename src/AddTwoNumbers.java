//My answer have some errors and now looking forward a evolution

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = recover(l1);
        int num2 = recover(l2);
        int sum = num1 + num2;
        int sum1 = sum;
        int digit = 0;
        while ( sum1 != 0){
            sum1 %= 10;
            digit ++;
        }
        return splitOver(sum,digit);
    }

    public int recover(ListNode listNode){
        int num = 0;
        int digit = 1;
        while( listNode != null){
            num += listNode.val * digit;
            listNode = listNode.next;
            digit *= 10;
        }
        return num;
    }

    public ListNode splitOver(int sum, int digit){
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode p = head;
        while(digit != 0 ){
            p.val = sum % 10;
            if(digit > 1){
                ListNode q = new ListNode(0);
                q.next = null;
                p.next = q;
                p = q;
            }
            else
                p.next = null;
            digit--;
            sum /= 10;
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//      调试代码
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = null;
//
//        ListNode l4 = new ListNode(5);
//        ListNode l2 = new ListNode(6);
//        ListNode l3 = new ListNode(4);
//        l4.next = l2;
//        l2.next = l3;
//        l3.next = null;
//
//        ListNode p =new ListNode();
//        p.next = new addTwoNumbers(l1,l4);
//
//    }