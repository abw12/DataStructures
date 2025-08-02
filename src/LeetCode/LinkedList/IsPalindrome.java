package LeetCode.LinkedList;

public class IsPalindrome {
    // 1->2->3->2->1
//        1->2->3


    private static LinkedList.node reverse(LinkedList.node head){
        //null->1->2->3
        // null<-1<-2<-3
        LinkedList.node prev=null;
        while(head!=null){
            LinkedList.node nextNode = head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return prev;
    }

    public static boolean isPalindrome (LinkedList.node head){

        if(head == null || head.next == null) return false;

        LinkedList.node slow=head,fast=head;
        //find the midpoint of the list
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //this is for the odd list taking the right part smaller
        if(fast!=null){
            slow=slow.next;
        }
        slow=reverse(slow); //reverse the right part of the list
        fast=head; //move the fast pointer again to the start of the list

        while(slow!=null){
            if(slow.val != fast.val){ //comparing slow and fast
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(8);
        list.push(5);
        list.push(7);
        list.push(4);
        list.push(8);

        System.out.println(isPalindrome(list.head));

    }
}
