package proj5;

/**
 * Represents an Index (of words)
 *
 * An Index contains a word and its page number occurrences.  Words that
 * are considered insignificant are two or less in length, and are not granted
 * an entry in the index.
 *
 * INVARIANTS:
 * -Index is a Binary Search Tree that contains Pagelist objects
 * -Words only appear in the index once, along with their associated Pagelist
 * -Words only stay in the index if they appear less than 5 times in a text
 *
 * @author Hope Crisafi
 * @version 151 Fall 2022
 */

public class Index{

    private BinarySearchTree<Pagelist> holder;

    /**
     * default constructor
     */
    public Index(){
        this.holder = new BinarySearchTree<>();
    }

    /**
     * checks to see if a word is already in the index
     * @param word a word to see if contained
     * @return true if word is in the index, false if not
     */
    public boolean containsWord(String word){
        Pagelist toFind = new Pagelist(word);
        return this.holder.search(toFind);
    }

    /**
     * Checks to see if a given page is already associated with a word
     * @param pageNum a page number
     * @param word a word
     * @return true if page number is associated, false if not
     */
    public boolean wordContainsPage(int pageNum, String word){
        Pagelist toFind = new Pagelist(word);
        Pagelist data = this.holder.getData(toFind);
        return data.contains(pageNum);
    }


    /**
     * Add a page number to the word's Pagelist
     * @param pageNum page number to add
     * @param word word who's page number is to be added
     */
    public void addPageNum(int pageNum, String word){
        Pagelist toFind = new Pagelist(word);
        this.holder.getData(toFind).add(pageNum);
    }


    /**
     * makes an entry for a new word in the index
     * @param toAdd word to add to index
     * @param pageNum page number of word's first occurrence
     */
    public void makeEntry(String toAdd, int pageNum) {
        Pagelist newEntry = new Pagelist(toAdd);
        if (!this.holder.search(newEntry)) {
            newEntry.add(pageNum);
            this.holder.insert(newEntry);
        }
    }

    /**
     * Checks to see if the pagelist's capacity has been reached
     * @param word word who's pagelist to check
     * @return true if full, false if not
     */
    public boolean pagelistIsFull(String word){
        Pagelist toCheck = new Pagelist(word);
        Pagelist data = this.holder.getData(toCheck);
        if(data == null){
            return false;
        }
        return data.capacityReached();
    }

    /**
     * removes an entry
     * @param toRemove word of which entry to remove
     */
    public void delete(String toRemove){
        Pagelist toFind = new Pagelist(toRemove);
        Pagelist data = this.holder.getData(toFind);
        System.out.println("Deleting '" + data + "' from index.");
        this.holder.delete(data);
    }


    /**
     * @return the number of pages associated with a word
     */
    public int size(){
        return this.holder.size();
    }

    /**
     * prints the index in alphabetical order, with capital letters first
     */
    public void orderedPrint(){
        System.out.println("INDEX");
        System.out.println("-----");
        this.holder.orderedPrint();
    }


    /**
     * @return String representation of an Index
     */
    public String toString(){
        System.out.println("INDEX");
        System.out.println("-----");
        return this.holder.makeLL().toString();
    }




}
