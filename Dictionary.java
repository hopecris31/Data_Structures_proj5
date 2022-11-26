package proj5;

/**
* Represents a Dictionary
*
* A Dictionary contains words that previously had entries in the Index.  A word is
 * * only added to the Dictionary if the word has appeared at least five times
 * * in the text.
*
* INVARIANTS:
* -Dictionary cannot contain any duplicate words
 * -Words in the dictionary must have first appeared in the index
 * -Words must have appeared at least five times in the text to be in dictionary
 * -Words are printed in alphabetical order, with capital letters first
*
* @author Hope Crisafi
* @version 151 Fall 2022
*/

public class Dictionary {

    private BinarySearchTree<String> holder;

    /**
     * Default constructor
     */
    public Dictionary(){
        this.holder = new BinarySearchTree<>();
    }

    /**
     * Inserts a word into the Dictionary
     * @param toAdd word to insert
     */
    public void insert(String toAdd){
        this.holder.insert(toAdd);
    }


    /**
     * removes a word from the dictionary
     * @param toRemove word to remove
     */
    public void remove(String toRemove){
        this.holder.delete(toRemove);
    }


    /**
     * checks to see if a word is already in the dictionary
     * @param word word to see if contained
     * @return true if word is in dictionary, false if not
     */
    public boolean contains(String word){
        return this.holder.search(word);
    }


    /**
     * Prints the words in the Dictionary in alphabetical
     * order, with capital letters first
     */
    public void orderedPrint(){
        System.out.println("DICTIONARY");
        System.out.println("----------");
        this.holder.orderedPrint();
    }


    /**
     * @return String representation of the Dictionary
     */
    public String toString(){
        System.out.println("DICTIONARY");
        System.out.println("----------");
        return this.holder.makeLL().toString();
    }

}
