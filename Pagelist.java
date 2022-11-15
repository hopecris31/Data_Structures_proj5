package proj5;

public class Pagelist<T> {

    private Object[] holder;
    private int size;
    private final int DEFAULT_CAPACITY = 4;
    private final int EMPTY = 0;
    private final int LAST_INDEX = size()-1;

    public Pagelist(){
        this.holder = new Object[DEFAULT_CAPACITY];
        this.size = EMPTY;
    }

    public Pagelist(int capacity){
        this.holder = new Object[capacity];
        this.size = EMPTY;
    }

    public void add(T toAdd){
        try{
            if(!this.contains(toAdd)){
                this.holder[size()] = toAdd;
                this.size++;
            }
        }
        catch (Exception capacityReached){
            System.out.println("Item " + toAdd + " was not added. Pagelist capacity reached.");
        }
    }

    public void add1(T toAdd){
            if(!this.contains(toAdd) && !this.capacityReached()){
                this.holder[size()] = toAdd;
                this.size++;
            }
    }

    public void remove(T toRemove){
        for(int i=0; i<this.size(); i++){
            if(this.holder[i] == toRemove){
                this.removeAndShift(i);
                this.size--;
            }
        }
    }

    private void removeAndShift(int index){
        for(int i=index; i<this.size(); i++){
            if(i == this.size()-1){
                this.holder[i] = null;
            }
            else{
                this.holder[i] = this.holder[i+1];
            }
        }
    }

    private Object getLastItem() {
        return this.holder[LAST_INDEX];
    }

    private boolean capacityReached() {
        return this.size() == this.getCapacity();
    }

    public int getCapacity(){
        return this.holder.length;
    }

    public boolean contains(T toFind){
        if(!this.isEmpty()){
            for(int i=0; i<this.size(); i++){
                if(this.holder[i] == toFind){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEmpty(){
        return this.size() == EMPTY;
    }


    public int size(){
        return this.size;
    }


    public String toString(){
        String toReturn = "( ";
        for(int i=0; i<this.size(); i++){
            toReturn += this.holder[i] + " ";
        }
        return toReturn + ")";
    }


}
