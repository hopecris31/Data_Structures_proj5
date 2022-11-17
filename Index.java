package proj5;

public class Index{

    private BinarySearchTree<Pagelist> holder;
    private int size;
    private final int EMPTY = 0;

    public Index(){
        this.holder = new BinarySearchTree<>();
        this.size = EMPTY;
    }


    public boolean containsWord(String word){
        Pagelist toFind = new Pagelist(word);
        Pagelist data = this.holder.getData(toFind);
        if(data == null){
            return false;
        }
        return this.holder.contains(toFind);
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
    public void makeEntry(String toAdd){
        Pagelist newEntry = new Pagelist(toAdd);
        if(toAdd.length() > 2 && !this.holder.contains(newEntry)){
            this.holder.insert(new Pagelist(toAdd));
            this.size++;
        }
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
        this.holder.delete(toFind);
        this.size--;
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
