//other`s answer, ht solve this problem at one loop; learn it!
class addTwoNumbersAnswer {
    public ListNode addTwoNumbersOthers (ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            ListNode cursor = root;
            int carry = 0;
            while(l1 !=null || l2 != null||carry !=0) {
                int l1Val = l1 != null ? l1.val : 0;
                int l2Val = l2 != null ? l2.val : 0;
                int sumVal = l1Val + l2Val + carry;
                carry = sumVal / 10;                //carry记录进位的值

                ListNode sumNode = new ListNode(sumVal % 10);   //把当前的个位记入节点
                cursor.next = sumNode;
                cursor = sumNode;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

        return root.next;
    }
}
