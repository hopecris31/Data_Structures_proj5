package proj5;

/**
 * LinkedList class: represents a Linked List
 *
 *  INVARIANTS:
 *  - size must always equal the number of nodes in the list
 *  - the last node points to null
 *  - the first node points to the first node in the list
 *      - if length is equal to 0, the first node points to null
 *  - list node next refers to the next node in the list
 */
public class LinkedList<T extends Comparable<T>>{
    private int length;
    private ListNode firstNode;

    private final int EMPTY = 0;


    /**
     * Default LinkedList constructor
     */
    public LinkedList() {
        length = 0;
        firstNode = null;
    }

    /**
     * @return the length of the LinkedList
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @return true if the LinkedList is empty, false if not
     */
    public boolean isEmpty(){
        return this.length == 0;
    }


    /**
     * inserts a given data at the head of the linkedList
     * @param data string to insert
     */
    public void insertAtHead(T data) {
        ListNode newNode = new ListNode((Comparable) data);
        if (this.isEmpty()){
            firstNode = newNode;
        }
        else{
            newNode.next = firstNode;
            firstNode = newNode;
        }
        length++;
    }


    /**
     * Inserts data at the end of a LinkedList
     * @param data string to insert
     */
    public void insertAtEnd(T data){
        if(!this.isEmpty()){
            ListNode last = this.getLastItem();
            ListNode newNode = new ListNode((Comparable) data);
            last.next = newNode;
            this.length++;
        }
        else{
            this.insertAtHead(data);
        }
    }


    /**
     * Inserts given data after a specified string
     * @param prevData string of which new item is to be inserted after
     * @param data string to be inserted
     */
    public void insertAfter(String prevData, String data){
        if(!this.isEmpty()){
            ListNode runner = this.getFirstNode();

            while(runner != null && !runner.getData().equals(prevData)){
                runner = runner.getNext();
            }
            if(runner != null){
                ListNode newNode = new ListNode(data);
                if(runner.getNext() == null) {
                    newNode.next = null;
                }
                else {
                    newNode.next = runner.getNext();
                }
                runner.next = newNode;
                length++;
            }
        }
    }


    /**
     * Inserts given data before a specified string
     * @param nextData string of which new item is to be inserted before
     * @param data string to be inserted
     */
    public void insertBefore(String nextData, String data){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = null;

            while(runner != null && !runner.getData().equals(nextData)){
                prev = runner;
                runner = runner.getNext();
            }
            if(runner != null){
                ListNode newNode = new ListNode(data);
                if(isHead(nextData)) {
                    newNode.next = this.getFirstNode();
                    this.firstNode = newNode;
                }
                else {
                    prev.setNext(newNode);
                    newNode.setNext(runner);
                }
                length++;
            }
        }
    }


    /**
     * removes the given String from the Linked List.  If there are duplicates, removes the first instance.
     * @param toRemove the String to remove
     */
    public void remove(String toRemove){
        ListNode runner = this.firstNode;
        ListNode prev = null;

        while(runner != null && !runner.getData().equals(toRemove)) {
            prev = runner;
            runner = runner.getNext();
        }
        if(runner != null){
            if(runner == this.getFirstNode()){
                this.firstNode = runner.getNext();
            }
            else{
                prev.next = runner.getNext();
            }
            runner.next = null;
            length--;
        }
    }


    /**
     * clears the linkedList
     */
    public void clear(){
        this.length = EMPTY;
        this.firstNode = null;
    }

//    public void bubbleSort(){
//        ListNode<T> runner = this.firstNode;
//        ListNode nextNode = null;
//
//        T temp;
//
//        if(this.firstNode == null){
//            return;
//        }
//        else{
//            while(runner != null){
//                nextNode = runner.next;
//
//                while(nextNode != null){
//                    if(runner.getData().compareTo(nextNode.getData())){
//
//                    }
//                }
//            }
//        }

    //}


    /**
     * checks to see if a LinkedList contains a given string
     * @param data data to check if contains
     * @return true if contains, false if not
     */
    public boolean contains(String data){
        ListNode runner = this.getFirstNode();
        while(runner != null){
            if(runner.getData().equals(data)){
                return true;
            }
            runner = runner.getNext();
        }
        return false;
    }


    /**
     * clones a LinkedList
     * @return an exact copy of the LinkedList
     */
    public LinkedList clone(){
        LinkedList cloneList = new LinkedList();
        ListNode runner = this.getFirstNode();
        while(runner != null){
            cloneList.insertAtEnd(runner.getData());
            if(runner.getNext() == null){
                runner.setNext(null);
            }
            runner = runner.getNext();
        }
        cloneList.length = this.getLength();
        return cloneList;
    }


    /**
     * removes the last item in a LinkedList
     */
    public void removeLast(){
        if(!this.isEmpty()){
            this.getTail().setNext(null);
            length--;
        }
    }


    /**
     * removes the item at the head of the LinkedList
     */
    public void removeAtHead(){
        if(!this.isEmpty()){
            this.firstNode = firstNode.getNext();
            length--;
        }
    }


    /**
     * adds all items of a given LinkedList to the current LinkedList
     * @param toAdd LinkedList of which items are to be added
     */
    public void addAll(LinkedList toAdd){
        if(this.isEmpty()){
            this.firstNode = toAdd.firstNode;
        }
        else{
            this.getLastItem().setNext(toAdd.firstNode);
        }
        this.length += toAdd.getLength();
    }

    /**
     * gets the index of the first instance of given data
     * @param data index of data to find
     * @return the index of the data
     */
    public int getIndex(String data){
        if(!isEmpty()){
            ListNode runner = this.getFirstNode();
            int count = 0;
            while(runner != null && !runner.getData().equals(data)){
                runner = runner.getNext();
                count++;
            }
            if(runner != null){
                return count;
            }
        }
        return -1;
    }



    /**
     * adds a given string at the specified index of a LinkedList
     * @param index index of which data is to be added
     * @param toAdd data to be added
     */
    public void insertAtIndex(int index, String toAdd){
        if(!this.isEmpty()){
            ListNode runner = this.firstNode;
            ListNode prev = null;
            int currIndex = 0;
            while(runner != null && currIndex != index){
                prev = runner;
                runner = runner.getNext();
                currIndex++;
            }
            if(runner != null){
                ListNode newNode = new ListNode(toAdd);
                if(currIndex == 0){
                    this.firstNode = newNode;
                }
                else{
                    prev.next = newNode;
                }
                newNode.next = runner;
                length++;
            }
        }
    }


    /**
     * removes the item at a given index
     * @param index the index of which data is to be removed
     */
    public void removeAtIndex(int index){
        if(!this.isEmpty()){
            ListNode runner = this.getFirstNode();
            ListNode prev = null;
            int currIndex = 0;
            while(runner != null && currIndex != index){
                prev = runner;
                runner = runner.getNext();
                currIndex++;
            }
            if(runner != null){
                prev.next = runner.getNext();
                length--;
            }
        }
    }


    /**
     * checks to see if one LinkedList is equal to another LinkedList
     * @param other another LinkedList to check equality
     * @return true if they are equal, false if not
     */
    public boolean equals(LinkedList other) {
        if(this.getLength() != other.getLength()) {
            return false;
        }
        ListNode thisRunner = this.firstNode;
        ListNode otherRunner = other.firstNode;
        while(thisRunner != null && otherRunner != null){
            if(!thisRunner.getData().equals(otherRunner.getData())){
                return false;
            }
            thisRunner = thisRunner.getNext();
            otherRunner = otherRunner.getNext();
        }
        return thisRunner == null && otherRunner == null;
    }


    /**
     * @return a String representation of the LinkedList
     */
    public String toString(){
        String toReturn = "";
        ListNode runner = firstNode;
        int counter = 1;
        while(runner != null){
            toReturn = toReturn + counter + ") " + runner;
            runner = runner.getNext();
            if(runner != null){
                toReturn = toReturn + "\n";
                counter++;
            }
        }
        toReturn = toReturn + "";
        return toReturn;
    }

    /** ------------------------------
     *      PRIVATE HELPER METHODS
     * _______________________________
     */


    /**
     * gets the first node in a Linked List
     * @return the first node
     */
    private ListNode getFirstNode() {
        return this.firstNode;
    }

    /**
     * gets the last node in a Linked List
     * @return the last node
     */
    private ListNode getLastItem(){
        if(this.isEmpty()){
            return null;
        }
        ListNode runner = this.firstNode;
        while(runner.getNext() != null){
            runner = runner.getNext();
        }
        return runner;
    }


    /**
     * gets the tail, or the second last node in a Linked List
     * @return the tail node
     */
    private ListNode getTail(){
        if(this.isEmpty()){
            return null;
        }
        ListNode runner = this.firstNode;
        ListNode prev = null;
        while(runner.getNext() != null) {
            prev = runner;
            runner = runner.getNext();
        }
        return prev;
    }


    /**
     * checks to see if the given string is at the head of a linkedList
     * @param data data to see if it is at the head
     * @return true if at head, false if not
     */
    private boolean isHead(String data){
        return this.firstNode.getData().equals(data);
    }

}