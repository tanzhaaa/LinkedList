public class LinkedList {
    /*
    * 本链表有一个什么信息都没有存放的头节点headNode,该节点不算长度，len只算了有数值的节点的个数
    * 结构为：
    * this.head
    *     |
    *     v
    * headNode:MIN_VALUE -> node -> ......
    * */
    private int len = 0;
    private ListNode head = new ListNode(Integer.MIN_VALUE);
    private ListNode tail = null;
    public LinkedList(ListNode head){
        this.head.next = head;
        this.tail = head;
        this.len = 1;
    }
    public void addNode(ListNode node){
        this.tail.next = node;
        node.next = null;
        len++;
        this.tail = node;
    }

    public boolean removeNode(int num){
        if (this.len == 0)
            return false;
        ListNode p = this.head.next;
        ListNode q = this.head;
        while(p != null){
            if (p.val ==num){
             q.next = p.next;
             this.len--;
             return true;
            }

            p = p.next;
            q = q.next;
        }
        return false;
    }

    public int findIndex(int x){
        int pos = 0;
        boolean flag = true;
        ListNode p = this.head.next;
        while (p != null && flag) {
            if(p.val == x)
                flag = false;
            pos ++;
            p = p.next;
        }
        if(flag)
            return -1;
        return pos;
    }

    public void printList(){
        if(this.len == 0){
            System.out.println("NULL");
            return;
        }
        ListNode p = this.head.next;
        while(p != null){
            if(p.next != null)
                System.out.print(p.val+"->");
            else
                System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode q = new ListNode(2);
        ListNode u = new ListNode(3);
        ListNode v = new ListNode(4);
        LinkedList a = new LinkedList(p);
        a.addNode(q);
        a.addNode(u);
        a.addNode(v);
        a.printList();
        System.out.println("3 is at "+a.findIndex(3));
        System.out.println("10 is at "+a.findIndex(10));

        a.removeNode(4);
        a.printList();
        a.removeNode(3);
        a.printList();
        a.removeNode(2);
        a.printList();
        a.removeNode(1);
        a.printList();
    }

}
