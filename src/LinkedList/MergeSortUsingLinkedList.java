package LinkedList;

class LinkedList{

    static class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    node head =null;

    public void push(int val){
        node newNode = new node(val);
        newNode.next=head;
        head =newNode;
    }

    public void printList (node headRef){
        while(headRef!=null){
            System.out.print(headRef.val + " ");
            headRef=headRef.next;
        }
    }

    private node getMiddleNode(node head){

        node slow=head,fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    private node conquereList(node left,node right){

        node result=null;
        //base conditions
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }

        //Pick the smaller val among two part of node by comparing and add that to the result node
        //at this moment for first time the left and right node will be single node (single unit of element after the divide operation)
        //and will keep on joining the divided by part into single list by recursively comparing and the merging the node in sorted order
        //this function will return the final sorted list
        if(left.val < right.val){
            result=left;
            result.next=conquereList(left.next,right);
        }else {
            result=right;
            result.next=conquereList(left,right.next);
        }

        return result;
    }

    public node mergeSort (node h){

        //base condition
        if(h == null || h.next == null){
            return h;
        }

        //find the middle of the list
        node middle = getMiddleNode(h);
        //take out the middle element next pointer value in new node and make the middle element point to null
        node nextToMiddle = middle.next;
        middle.next=null;

        //now recursively divide the left and right part of the list until the single element remain
        node left = mergeSort(h); //this recursive call is dividing the list

        //nextToMiddle is the right part of the list everytime we divide list into halves
        node right = mergeSort(nextToMiddle);

        node sortedList = conquereList(left,right);
        return sortedList;
    }



}



public class MergeSortUsingLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(8);
        list.push(4);
        list.push(7);
        list.push(4);
        list.push(8);

        System.out.println("original list : ");
        list.printList(list.head);

//        list.head =list.mergeSort(list.head);
//        System.out.println("\nsorted list: ");
//        list.printList(list.head);


    }
}
