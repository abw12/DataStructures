package LeetCode.LinkedList;

/*Given head, the head of a linked list, determine if the linked list has a cycle in it.

        There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
         Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
         Note that pos is not passed as a parameter.

        Return true if there is a cycle in the linked list. Otherwise, return false.*/

public class LinkedListCycle {

    //3->2->1-> -4 -> 2 (as pos is pointing at 1st index)
    public boolean hasCycle(ListNode head) {
        //this approach uses an extra space o(n) to store the node in the set
//         HashSet nodeSet = new HashSet<>();

//         while(head!=null){
//             if(!nodeSet.add(head) ){
//                 return true;
//             }
//             head=head.next;
//         }
//         return false;

        //using floyd's tortoise and ahre algorithm we can acheive the O(1) space complexity

        ListNode slow = head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;

    }
}
