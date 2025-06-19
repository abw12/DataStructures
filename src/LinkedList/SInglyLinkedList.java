package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class SInglyLinkedList {
    public SinglyLinkedListNode head;

    public SinglyLinkedListNode tail;
    public int length;

    public SInglyLinkedList(int value) {
        this.head = new SinglyLinkedListNode(value);
        this.tail = head;
        this.length++;
    }

    @Override
    public String toString() {
        return "{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    public void append(int value){
        SinglyLinkedListNode newNode=new SinglyLinkedListNode(value);
        tail.setNext(newNode);
        tail=newNode;
        length++;
    }

    public void prepand(int value){
        SinglyLinkedListNode newNode= new SinglyLinkedListNode(value);
        newNode.setNext(head);
        head=newNode;
        length++;
    }

    public void insert(int value,int ind){
        int index = wrapIndex(ind);

        SinglyLinkedListNode newNode=new SinglyLinkedListNode(value);
        SinglyLinkedListNode currentNode=head;

        currentNode=traverseToIndex(index,currentNode);
        SinglyLinkedListNode allNextNode= currentNode.getNext();

        currentNode.setNext(newNode);
        newNode.setNext(allNextNode);
        length++;
    }

    public void remove(int index){
        int ind=wrapIndex(index);

        SinglyLinkedListNode currentNode=head;
        currentNode=traverseToIndex(ind,currentNode);
        SinglyLinkedListNode NodeToRemove = currentNode.getNext();
        SinglyLinkedListNode remainingNode=NodeToRemove.getNext();
        currentNode.setNext(remainingNode);
        length--;

    }

    public void reverse(){
        //1->2->3->4

        SinglyLinkedListNode first=head;
        tail=head;
        SinglyLinkedListNode second=head.getNext();
        for(int i=0 ;i < length -1 ; i++){
            SinglyLinkedListNode temp=second.getNext();
            second.setNext(first);
            first=second;
            second=temp;
        }
        head.setNext(null);
        head=first;
    }

    private SinglyLinkedListNode traverseToIndex(int index,SinglyLinkedListNode currentNode) {
        for(int i =0; i < index-1 ;i++){
            currentNode=currentNode.getNext();
        }
        return currentNode;
    }

    private int wrapIndex(int index) {
        return Math.min(index,length);
    }

    private void printList(){
        List<Integer> linkedList = new ArrayList<Integer>();
        SinglyLinkedListNode currentNode=head;
        for(int i =0; i < length;i++ ){
            linkedList.add(currentNode.getValue());
            currentNode=currentNode.getNext();
        }
        System.out.println("LinkedList: "+ linkedList.toString());
    }

    public void print() {
        if(head == null) {
            return;
        }
        SinglyLinkedListNode currentNode = head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static SinglyLinkedListNode mergeList(SInglyLinkedList list1,SInglyLinkedList list2){
            if(list1==null && list2 == null){
                return null;
            }

            SinglyLinkedListNode head_list1=list1.head;
            SinglyLinkedListNode head_list2=list2.head;
            SinglyLinkedListNode node = new SinglyLinkedListNode(0);
            SinglyLinkedListNode temp=node;

            while(head_list1!=null && head_list2!=null){
                if(head_list1.getValue() <= head_list2.getValue()){
                    temp.setNext(head_list1);
                    head_list1=head_list1.getNext();
                }else{
                    temp.setNext((head_list2));
                    head_list2=head_list2.getNext();
                }
                temp=temp.getNext();
            }
            if(head_list1!=null){
                temp.setNext(head_list1);
            }else{
                temp.setNext(head_list2);
            }
            return  node.getNext();
    }



    public static void main(String[] args) {
        SInglyLinkedList list1 =new SInglyLinkedList(1);
        list1.append(2);
        list1.append(4);
//        list1.prepand(7);
//        list1.insert(2,2);
//        list1.remove(3);
        list1.print();
        list1.printList();
        System.out.println("List 1: " + list1.toString());
//        list1.reverse();
//        list1.print();
//        list1.printList();
//        System.out.println("List reversed: " + list1.toString());
        SInglyLinkedList list2 = new SInglyLinkedList(1);
        list2.append(3);
        list2.append(4);
        list2.print();
        list2.printList();
        System.out.println("List 2: " + list2.toString());
        System.out.println("MergedLinkedList : "+mergeList(list1,list2).toString());
    }

}
