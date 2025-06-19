package LinkedList;

public class ReorderLinkedList extends  SInglyLinkedList{

    private SinglyLinkedListNode head;

    private SinglyLinkedListNode tail;

    private int length;

    public ReorderLinkedList(int value){
        super(value);
    }

    public void reorderList(ReorderLinkedList list){
        if(list == null ) return;

        //tail of 1st list
        SinglyLinkedListNode prev =null;
        //head of 2nd list
        SinglyLinkedListNode slow=list.head;
        //tail of 2nd list
        SinglyLinkedListNode fast=list.head;
        //head of 1st list
        SinglyLinkedListNode l1=list.head;

        while(fast!=null && fast.next.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.setNext(null);

        SinglyLinkedListNode l2 = reverseList(slow);



    }

    public SinglyLinkedListNode reverseList(SinglyLinkedListNode head){
       SinglyLinkedListNode prev=null;
        SinglyLinkedListNode first=head;
        SinglyLinkedListNode second=head.getNext();
        while(head.next!=null){
            SinglyLinkedListNode temp=second.getNext();
            second.setNext(first);
            first=second;
            second=temp;
        }

        return prev;

    }



    public static void main(String[] args) {
        ReorderLinkedList head= new ReorderLinkedList(1);
        head.append(2);
        head.append(3);
        head.append(4);
        System.out.println("Input Linked list: ");
        head.print();


    }

}
