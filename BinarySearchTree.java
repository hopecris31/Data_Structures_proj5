package proj5;

/**
 * 
 * 
 * @author Chris Fernandes, Kristina Striegnitz
 * @version Fall 2022
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BSTNode<T> root;
	
	/**
	 * Default constructor
	 */
	public BinarySearchTree() {
		root = null;
	}
    
    /**
	 * inserts an new value into this BST    
	 * @param newValue value to insert
	 */
	public void insert(T newValue) {
		root = insert(root,newValue);
	}

	public T getData(T toFind){
		return getData(root, toFind);
	}

	//returns a pointer to the node of that value
	private T getData(BSTNode<T> subroot, T toFind){
		if(!this.contains(toFind)){
			return null;
		}
		else if (subroot.key.compareTo(toFind) > 0){
			return getData(subroot.llink, toFind);
		}
		else if(subroot.key.compareTo(toFind) < 0){
			return getData(subroot.rlink, toFind);
		}
		else{
			return subroot.key;
		}
	}

	/**
	 * inserts value into tree rooted at subroot
	 * 
	 * @param subroot  subroot of tree to insert into
	 * @param value  the value to insert
	 * @return   root of the subtree I've just finished inserting into
	 */
	private BSTNode<T> insert(BSTNode<T> subroot, T value) {
		if (subroot==null){
			return new BSTNode<T>(value);
		}
		else if (value.compareTo(subroot.key) > 0){
			subroot.rlink = insert(subroot.rlink,value);
			return subroot;
		}
		else {
			subroot.llink = insert(subroot.llink, value);
			return subroot;
		}
	}
	
	/**
	 * deletes value from tree.  If value not there, do nothing.
	 * @param value  value to delete
	 */
	public void delete(T value) {
		delete(this.root, value);
	}
	
	/**
	 * deletes value from tree rooted at subroot
	 * @param subroot  root of tree to be deleted from
	 * @param value  element to delete
	 * @return pointer to tree rooted at subroot that has value removed from it
	 */
	private BSTNode<T> delete(BSTNode<T> subroot, T value) {
		/**
		 * if subroot is an empty tree
		 *     return null
		 * else if victim is on the left of subroot
		 *     subroot's left link must become what recursion on subroot's left child gives you
		 * else if victim is on the right of subroot
		 *     subroot's right link must become what recursion on subroot's rlink gives you
		 * else
		 *     victim is found!
		 *     case 1) victim is a leaf
		 *         return null
		 *     case 2) victim has exactly one (right) subtree
		 *         return pointer to that right subtree
		 *     (case 2a - take care of just left subtree only)
		 *     case 3) victim has two subtrees
		 *         pick a replacement (largest value in the left subtree)
		 *         move the data from replacement node to victim node
		 *         delete the replacement
		 */

		//BSTNode<T> subroot1 = search(subroot, value); //locate the node
		if(subroot == null){
			return null;
		}
		else if (value.compareTo(subroot.key) > 0){ //if value is greater than subroot
			subroot.rlink = delete(subroot.rlink, value);
		}
		else if (value.compareTo(subroot.key) < 0){ // make a const for 0/make this more readable?
			subroot.llink = delete(subroot.llink, value);
		}
		else{
			if(subroot.isLeaf()){
				return null;
			}
			else if(subroot.hasRightChildOnly()){
				return subroot.rlink;
			}
			else if(subroot.hasLeftChildOnly()){
				return subroot.llink;
			}
			else{
				T greatestValue = findSubtreeMax(subroot).key;
				delete(greatestValue);
				subroot.key = greatestValue;
			}
		}
		return subroot; //why do we want to return subroot at the end
	}

	private BSTNode<T> findSubtreeMax(BSTNode<T> subroot){
		if(subroot == null){
			return null;
		}
		else if(subroot.rlink == null){
			return subroot;
		}
		else{
			return findSubtreeMax(subroot.rlink);
		}
	}

	public T findMax (){
		try {
			return findSubtreeMax(this.root).key;
		}
		catch (Exception emptyTree) {
			return null;
		}
	}

	public T findMin (){
		try {
			return findSubtreeMin(this.root).key;
		}
		catch (Exception emptyTree) {
			return null;
		}
	}

	private BSTNode<T> findSubtreeMin(BSTNode<T> subroot){
		if(subroot == null){
			return null;
		}
		else if(subroot.llink == null){
			return subroot;
		}
		else{
			return findSubtreeMin(subroot.llink);
		}
	}

    /**
     * checks whether the target value is in the tree
     * @return true or false to indicate whether the target value is in the tree
     */
    public boolean contains(T target) {
		return contains(this.root, target) != null;
    }


	private BSTNode<T>  search(BSTNode<T> subroot, T toFind){
		if(subroot == null){
			return null;
		}
		return null;
	}


	private BSTNode<T> contains(BSTNode<T> subroot, T target){
		if(subroot == null){
			return null;
		}
		else if (target.compareTo(subroot.key) > 0){
			return contains(subroot.rlink, target);
		}
		else if (target.compareTo(subroot.key) < 0){
			return contains(subroot.llink, target);
		}
		else{
			return subroot;
		}
	}

	public LinkedList<T> makeArray(){
		return makeArray(this.root, new LinkedList<T>());
	}

	private LinkedList<T> makeArray(BSTNode<T> subroot, LinkedList<T> ll){
		if(subroot == null){
			return ll;
		}
		else{
			if(subroot.llink != null){
				makeArray(subroot.llink, ll);
			}
			if(subroot.rlink != null){
				makeArray(subroot.rlink, ll);
			}
			ll.insertAtEnd(subroot.key);
		}
		return ll;
	}

	public int size(){
		return size(this.root);
	}
	private int size(BSTNode<T> subroot){
		if(subroot == null){
			return 0;
		}
		else{
			return 1 + size(subroot.llink) + size(subroot.rlink);
		}
	}

	/**
	 * returns tree as printable string
	 * @return tree in string format with form (left subtree) value (right subtree)
	 */
	public String toString(){
		return toString(root);
	}

	/**
	 * recursive helper method for toString()
	 *
	 * @param N root of subtree to make into a string
	 * @return string version of tree rooted at N
	 */
	private String toString(BSTNode<T> N){
		String ret = "";
		if (N != null){
			ret += "(";
			ret += toString(N.llink);
			ret += "  " + N + "  ";
			ret += toString(N.rlink);
			ret += ")";
		}
		return ret;
	}


}