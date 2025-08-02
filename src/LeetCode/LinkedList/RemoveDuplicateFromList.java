package LeetCode.LinkedList;


//Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
// Return the linked list sorted as well.
public class RemoveDuplicateFromList
{


    public static ListNode removeDuplicate(ListNode head){
        ListNode currentNode=head;
        while(currentNode != null && currentNode.next!=null){

            if(currentNode.getVal() == currentNode.next.getVal()){

                currentNode.next=currentNode.next.next;
            }else{
                currentNode=currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        LinkedListNode linkedListNode = new LinkedListNode();
        head= linkedListNode.add(head,new ListNode(1));
        head=linkedListNode.add(head,new ListNode(1));
        head=linkedListNode.add(head,new ListNode(2));
        head=linkedListNode.add(head,new ListNode(2));
        head=linkedListNode.add(head,new ListNode(2));
        head=linkedListNode.add(head,new ListNode(3));
        System.out.println(head);
        linkedListNode.printLinkedListNode(head);
        System.out.println("\n==================================");
        System.out.println("Remove Duplicates From list: " + removeDuplicate(head));
        linkedListNode.printLinkedListNode(head);
    }
}
