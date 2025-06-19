package LinkedList;

public class SinglyLinkedListNode
{

    public int value;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public SinglyLinkedListNode(int value, SinglyLinkedListNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
