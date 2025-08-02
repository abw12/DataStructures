package LeetCode.LinkedList;

public class SortList {

    private static ListNode sortList(ListNode head){
        //base condition
        if(head == null || head.next == null)
            return head;

        // use two pointer slow and fast fast will start from 2nd node
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next !=null){
            slow=slow.next; //increment by one pointer
            fast=fast.next.next; //increment by two pointer
        }

        // slow will be at mid-1 position in the list (last index of 1st half of the list)
        ListNode mid = slow.next; // mid will be the starting point of the 2nd part of the list
        slow.next=null; // last index of the 1st part this way it will separate the 1st and 2nd part of list

        // recursively split the left and right halves of the linkedlist till single unit
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // now merge the two sorted halves of the linked list
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(left!=null && right != null){
            if(left.val < right.val){
                current.next=left;
                left=left.next;
            }else{
                current.next=right;
                right=right.next;
            }
            current=current.next;
        }

        //add remaining element to the end of linkedlist
        if(left!=null)
            current.next=left;
        if(right!=null)
            current.next=right;
        return dummy.next; //since dummy.next is still pointing to the head of the current.
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sortedList = sortList(head);
        while(sortedList != null){
            System.out.print(sortedList.val + " ");
            sortedList = sortedList.next;
        }
    }
}
