package proj5;

public class Dictionary {

    private BinarySearchTree<String> holder;
    private int size;
    private final int EMPTY = 0;

    public Dictionary(){
        this.holder = new BinarySearchTree<>();
        this.size = EMPTY;
    }

    public void insert(String toAdd){
        this.holder.insert(toAdd);
        this.size++;
    }

    public void remove(String toRemove){
        this.holder.delete(toRemove);
        this.size--;
    }

    public boolean contains(String word){
        return this.holder.contains(word);
    }

    public int size(){
        return this.size;
    }

    private String[] makeWordList(){
        return null;
    }

    public String toString(){
        return this.holder.makeLL().toString();
    }

}
