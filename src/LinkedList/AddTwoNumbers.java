package LinkedList;

/*You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0); // creating an result list
        ListNode dummy = result; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
        // We will add that as well into our list
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0; // intialising our sum
            if (l1 != null) { // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) { // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum / 10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            dummy.next = node; // dummy will point to that new node if we get
            dummy = dummy.next; // update the current every time
        }
        return result.next; // return result.next bcz, we don't want the value we have consider in it intially!!
    }
}
