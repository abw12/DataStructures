package LeetCode.LinkedList;

/*You are given the heads of two sorted linked lists list1 and list2.

        Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

        Return the head of the merged linked list*/

//time complexity is  O(n) since doing till end of the smallest list amoung two lists given
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2 == null)
        {
            return null;
        }
        ListNode finalResultNode = new ListNode(0);
        ListNode temp = finalResultNode;
        while(list1!=null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if(list1!=null)
        {
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        return finalResultNode.next;
    }
}
