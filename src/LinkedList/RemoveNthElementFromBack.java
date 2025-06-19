package LinkedList;

//Leetcode medium level question

/*Given the head of a linked list, remove the nth node from the end of the list and return its head.*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthElementFromBack {

/*
    // ListNode start = new ListNode(0);
    ListNode start = new ListNode(0,head);

    ListNode slow = start , fast = start;
 // start.next = head; //the above start node constructor is doing the same thing here creating a 0 value node and its next pointer
    is pointing to head (so slow and fast created will point to same ref values in memory)

    //move ahead the fast pointer till n+1 steps
    //to maintain n=1 gap between slow and fast pointer
        for(int i=1 ; i <= n+1 ; i++){
        fast=fast.next;
    }

    //now move slow and fast pointer together one by one til fast!=null
        while(fast!=null){
        slow=slow.next;
        fast=fast.next;
    }

    //now slow is at desired index ,so skip its next value which is the nth element to be removed
    slow.next=slow.next.next;
        return start.next; //since start is at 0 node which we created and its next is pointing to the head */

}
