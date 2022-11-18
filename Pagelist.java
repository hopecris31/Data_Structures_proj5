package proj5;

/**
 * Represents a Pagelist
 * A Pagelist is a holder that stores the page numbers that are associated with a
 * particular word.
 *
 * INVARIANTS:
 * -Each Pagelist holds one word, and a list of page numbers that that word appears on
 * -Pagelist objects are sorted/given value to based on their word's ASCII value
 * -Duplicate page numbers cannot be kept
 * -Only four different page numbers can be stored
 *
 * @author Hope Crisafi
 * @version 151 Fall 2022
 */

public class Pagelist implements Comparable<Pagelist> {

    private int[] holder;
    private int size;
    private String word;
    private final int DEFAULT_CAPACITY = 4;
    private final int EMPTY = 0;

    /**
     * Default Constructor
     */
    public Pagelist(){
        this.holder = new int[DEFAULT_CAPACITY];
        this.size = EMPTY;
        this.word = "";
    }

    /**
     * non-default constructor, takes word to associate
     * with page numbers
     * @param word a word
     */
    public Pagelist(String word){
        this.holder = new int[DEFAULT_CAPACITY];
        this.size = EMPTY;
        this.word = word;
    }


    /**
     * Adds a page number to the page number holder
     * @param toAdd page number
     */
    public void add(int toAdd){
        if(!this.contains(toAdd) && !this.capacityReached()){
            this.holder[size()] = toAdd;
            this.size++;
        }
    }

    /**
     * removes a page number from the page number holder
     * @param toRemove page number
     */
    public void remove(int toRemove){
        for(int i=0; i<this.size(); i++){
            if(this.holder[i] == toRemove){
                this.removeAndShift(i);
                this.size--;
            }
        }
    }

    /**
     * checks to see if the page number holder is full
     * @return true if full, false if there is remaining capacity
     */
    public boolean capacityReached(){
        return this.size() == this.holder.length;
    }

    /**
     * determines if a page number is already in the page number holder
     * @param toFind page number to find
     * @return true if in the page number list, false if not
     */
    public boolean contains(int toFind){
            for(int i=0; i<this.size(); i++){
                if(this.holder[i] == toFind){
                    return true;
                }
            }
        return false;
    }

    /**
     * @return the number of pages in the page number holder
     */
    public int size(){
        return this.size;
    }


    /**
     * @return the word belonging to the Pagelist
     */
    public String word(){
        return this.word;
    }

    /**
     * @return the String representation of the Pagelist
     */
    public String toString(){
        String toReturn = word + " {";
        for(int i=0; i<this.size(); i++){
            toReturn += this.holder[i];
            if(i != this.size()-1){
                toReturn += ", ";
            }
        }
        return toReturn + "}";
    }

    /**
     * compares the value of the Pagelist objects, determined
     * by which word has greater ASCII value
     * @param other the object to be compared.
     * @return 1 if this is greater, 0 if equal, -1 of other is greater
     */

    @Override
    public int compareTo(Pagelist other) {
        return this.word().compareTo(other.word());
    }

    /** ------------------------------
     *      PRIVATE HELPER METHODs
     * _______________________________
     */


    /**
     * removes the current element from the holder and shifts all elements
     * to the left
     * @param index page number to be removed
     */
    private void removeAndShift(int index){
        for(int i=index; i<this.size(); i++){
            if(i == this.size()-1){
                this.holder[i] = 0;
            }
            else{
                this.holder[i] = this.holder[i+1];
            }
        }
    }


}
