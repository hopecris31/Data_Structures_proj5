package proj5;

public class Pagelist implements Comparable<Pagelist> {

    private int[] holder;
    private int size;
    private String word;
    private final int DEFAULT_CAPACITY = 4;
    private final int EMPTY = 0;
    private final int LAST_INDEX = size()-1;

    public Pagelist(){
        this.holder = new int[DEFAULT_CAPACITY];
        this.size = EMPTY;
        this.word = "";
    }

    public Pagelist(String word){
        this.holder = new int[DEFAULT_CAPACITY];
        this.size = EMPTY;
        this.word = word;
    }

    public Pagelist(int capacity){
        this.holder = new int[capacity];
        this.size = EMPTY;
    }


    public void add(int toAdd){
//        if(this.capacityReached()){
//            addToDict(this.word);
//        }
        if(!this.contains(toAdd) && !this.capacityReached()){
            this.holder[size()] = toAdd;
            this.size++;
        }
    }

    public void remove(int toRemove){
        for(int i=0; i<this.size(); i++){
            if(this.holder[i] == toRemove){
                this.removeAndShift(i);
                this.size--;
            }
        }
    }

    public boolean capacityReached(){
        return this.size() == this.holder.length;
    }

    public int getCapacity(){
        return this.holder.length;
    }

    public boolean contains(int toFind){
            for(int i=0; i<this.size(); i++){
                if(this.holder[i] == toFind){
                    return true;
                }
            }
        return false;
    }

    //add method that returns word instance variable



    public int size(){
        return this.size;
    }

    public void ensureOrder(){
        return;
    }

    public String word(){
        return this.word;
    }

    public boolean equalsWord(String word){
        return this.word.equals(word);
    }


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

    @Override
    public int compareTo(Pagelist other) {
        return this.word().compareTo(other.word());
    }

    /** ------------------------------
     *      PRIVATE HELPER METHODS
     * _______________________________
     */

    private boolean isEmpty(){
        return this.size() == EMPTY;
    }



    private Object getLastItem() {
        return this.holder[LAST_INDEX];
    }


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
