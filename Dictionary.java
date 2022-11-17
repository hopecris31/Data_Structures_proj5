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
        return this.holder.search(word);
    }

    public int size(){
        return this.size;
    }

    private String[] makeWordList(){
        return null;
    }

    public void orderedPrint(){
        System.out.println("DICTIONARY");
        System.out.println("----------");
        this.holder.orderedPrint();
    }

    public String toString(){
        System.out.println("DICTIONARY");
        System.out.println("----------");
        return this.holder.makeLL().toString();
    }

}
