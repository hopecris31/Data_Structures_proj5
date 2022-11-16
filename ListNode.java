package proj5;


/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object.
 *
 *INVARINAT:
 * -each node contains data and a reference to the next node in a list
 */
public class ListNode<T> {
    public T data;
    public ListNode next;

    public ListNode(T new_data)
    {
        this.data = new_data;
        this.next = null;
    }

    public T getData(){
        return this.data;
    }


    public void setNext(ListNode nextNode){
        this.next = nextNode;
    }

    public String toString(){
        return this.data.toString();
    }

    public ListNode getNext() {
        return this.next;
    }
}