package LeetCode.LinkedList;
//leetcode way to solve the reverse of the linkedlist

class ListNode{
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int value){
        this.val =value;
        this.next=null;
    }

    public ListNode(int value ,ListNode next){
        this.val =value;
        this.next=next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class LinkedListNode{

    public ListNode add(ListNode head,ListNode newNode){
        if(head!=null ){
            ListNode currentNode=head;
            while(currentNode !=null && currentNode.next!=null){
                currentNode=currentNode.next;
            }
            currentNode.next=newNode;
        }
        return head;
    }

    public void printLinkedListNode(ListNode head){
        System.out.print(head.val);
        ListNode currentNode=head;
        while(currentNode!=null && currentNode.next!=null){
            System.out.print("->");
            System.out.print(currentNode.next.val);
            currentNode=currentNode.next;
        }
    }
}
public class ReverseLinkedList {



    //prev->1->2->3->4->null
    //iterative approach
    public static ListNode reverseList(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next_node = head.next;
            head.next=prev; // setting pointer to prev
            prev=head; //making the current head node as prev node (shifting by 1 position to right)
            head=next_node;
        }

        return prev;
    }

    //recursive approach
    public static ListNode reverseListRecusrion(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(1);
//        head.setNext(new ListNode(2));
        reverseList(head);
        reverseListRecusrion(head);
    }


}
