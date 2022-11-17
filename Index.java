package proj5;

/**
 * Represents an Index (of words)
 *
 * An Index contains a word and its page number occurrences.  Words that
 * are considered insignificant are two or less in length, and are not granted
 * an entry in the index.
 *
 * INVARIANTS:
 * -put invariants here💀💀
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

    public boolean wordContainsPage(int pageNum, String word){
        Pagelist toFind = new Pagelist(word);
        Pagelist data = this.holder.getData(toFind);
        if(data == null){
            return false;
        }
        return data.contains(pageNum);
    }


    public void addPageNum(int pageNum, String word){
        Pagelist toFind = new Pagelist(word);
        this.holder.getData(toFind).add(pageNum);
    }


    //clean up.  this is the add method
    public void makeEntry(String toAdd, int pageNum){
        Pagelist newEntry = new Pagelist(toAdd);
        this.holder.insert(newEntry);
        newEntry.add(pageNum);
    }

    public boolean pagelistIsFull(String word){
        Pagelist toCheck = new Pagelist(word);
        Pagelist data = this.holder.getData(toCheck);
        if(data == null){
            return false;
        }
        return data.capacityReached();
    }

    public void delete(String toRemove){
        Pagelist toFind = new Pagelist(toRemove);
        Pagelist data = this.holder.getData(toFind);
        System.out.println("Deleting '" + data + "' from index.");
        this.holder.delete(data);
    }


    public int size(){
        return this.holder.size();
    }

    public void orderedPrint(){
        System.out.println("INDEX");
        System.out.println("-----");
        this.holder.orderedPrint();
    }


    public String toString(){
        System.out.println("INDEX");
        System.out.println("-----");
        return this.holder.makeLL().toString();
    }




}
