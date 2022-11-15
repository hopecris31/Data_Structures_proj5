package proj5;

public class Index<T extends Comparable<T>>{

    private BinarySearchTree<Pagelist<Integer>> holder;
    private String word;
    private int size;
    private final int EMPTY = 0;

    public Index(){
        this.word = null;
        this.holder = new BinarySearchTree<>();
        this.size = EMPTY;
    }

    public Index(String word){
        this.word = word;
        this.holder = new BinarySearchTree<>();
        this.size = EMPTY;
    }

    //clean up
    public void insert(T toAdd){
        if(!this.holder.search(toAdd.word()) && toAdd.length() >2){ //correct instance variables/methods, cant use length() cuz not applicable to generic
            this.holder.insert(toAdd);
            //helper method that accesses the node instance variable in BST
        }
    }

    public void remove(T toRemove){
        return;
    }

    public void addToDict(Dictionary dictionary){
        return;
    }

    public boolean contains (T toContain){
        return false;
    }

    public int size(){
        return this.holder.size();
    }

    public boolean equals(){
        //if word is equal other??
    }

    public String toString(){
        return "";
    }




}
