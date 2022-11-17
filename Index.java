package proj5;

public class Index{

    private BinarySearchTree<Pagelist> holder;
    private int size;
    private final int EMPTY = 0;

    public Index(){
        this.holder = new BinarySearchTree<>();
        this.size = EMPTY;
    }


    public boolean contains(String word){
        Pagelist toFind = new Pagelist(word);
        return this.holder.contains(toFind);
    }


    public void addPageNum(int pageNum, String word){
        Pagelist toFind = new Pagelist(word);
        holder.getData(toFind).add(pageNum);
    }

    public void addToDict(Dictionary dictionary, String toAdd){
        dictionary.insert(toAdd);
    }

    //clean up.  this is the add method
    public void makeEntry(String toAdd){
        Pagelist newEntry = new Pagelist(toAdd);
        if( toAdd.length() > 2 && !this.holder.contains(newEntry)){
            this.holder.insert(new Pagelist(toAdd));
        }
    }

    public void delete(String toRemove){
        Pagelist toFind = new Pagelist(toRemove);
        this.holder.delete(toFind);
        System.out.println("Deleting '" + toFind + "' from index.");
    }


    public int size(){
        return this.holder.size();
    }



    public String toString(){
        return this.holder.makeLL().toString();
        //get alphabetical order and print
    }




}
