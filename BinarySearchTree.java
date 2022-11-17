package proj5;

/**
 * Represents a Binary Search Tree
 *
 * INVARIANTS:
 * -put invariants here💀💀
 * 
 * @author Hope Crisafi
 * @version 151 Fall 2022
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

	/**
	 * returns a pointer to the object stored in the BSTNode
	 * @param toFind object within tree to find
	 * @return pointer to that object
	 */
	public T getData(T toFind){
		return getData(root, toFind);
	}

	
	/**
	 * deletes value from tree.  If value not there, do nothing.
	 * @param value  value to delete
	 */
	public void delete(T value) {
		delete(this.root, value);
	}


	/**
	 * finds the max value in the tree
	 * @return max value
	 */
	public T findMax (){
		try {
			return findSubtreeMax(this.root).key;
		}
		catch (Exception emptyTree) {
			return null;
		}
	}

	/**
	 * finds the smallest value in the tree
	 * @return smallest value
	 */
	public T findMin (){
		try {
			return findSubtreeMin(this.root).key;
		}
		catch (Exception emptyTree) {
			return null;
		}
	}


    /**
     * checks whether the target value is in the tree
     * @return true or false to indicate whether the target value is in the tree
     */
    public boolean search(T target) {
		return search(this.root, target) != null;
    }


	/**
	 * Makes a linked list out of the values from a given tree
	 * @return a linked list of tree values
	 */
	public LinkedList<T> makeLL(){
		return makeLL(this.root, new LinkedList<T>());
	}

	/**
	 * @return the number of items in the tree
	 */
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
	 * prints the values in the tree in order from greatest to least value
	 */
	public void orderedPrint(){
		orderedPrint(root);
	}


	/**
	 * returns tree as printable string
	 * @return tree in string format with form (left subtree) value (right subtree)
	 */
	public String toString(){
		return toString(root);
	}


	/** ------------------------------
	 *      PRIVATE HELPER METHODS
	 * _______________________________
	 */

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
	 * deletes value from tree rooted at subroot
	 * @param subroot  root of tree to be deleted from
	 * @param value  element to delete
	 * @return pointer to tree rooted at subroot that has value removed from it
	 */
	private BSTNode<T> delete(BSTNode<T> subroot, T value) {

		if(subroot == null || value == null){
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
		return subroot;
	}


	/**
	 * searches the tree recursively for the highest value node in the subtree
	 * @param subroot root of tree to be searched
	 * @return pointer to node that contains a greater value
	 */
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

	/**
	 * searches the tree recursively for the lowest value node in the subtree
	 * @param subroot root of tree to be searched
	 * @return pointer to node that contains a lower value
	 */
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
	 * searches the tree recursively for the target node
	 * @param subroot root of tree to be searched
	 * @return pointer to node that is/leads to target
	 */
	private BSTNode<T> search(BSTNode<T> subroot, T target){
		if(subroot == null){
			return null;
		}
		else if (target.compareTo(subroot.key) > 0){
			return search(subroot.rlink, target);
		}
		else if (target.compareTo(subroot.key) < 0){
			return search(subroot.llink, target);
		}
		else{
			return subroot;
		}
	}

	/**
	 * recursively searches the tree for the node of which to retrieve data
	 * @param subroot root of tree to search
	 * @param toFind data to be found
	 * @return pointer to next node?
	 */
	private T getData(BSTNode<T> subroot, T toFind){
		if(subroot == null){
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
	 * recursively traverses the tree and adds all nodes to a linkedList
	 * @param subroot subroot of tree from which list is to be made
	 * @param ll linkedList of which values will be added to
	 * @return linkedList
	 */
	private LinkedList<T> makeLL(BSTNode<T> subroot, LinkedList<T> ll){
		if(subroot == null){
			return ll;
		}
		else{
			if(subroot.llink != null){
				makeLL(subroot.llink, ll);
			}
			if(subroot.rlink != null){
				makeLL(subroot.rlink, ll);
			}
			ll.insertAtEnd(subroot.key);
		}
		return ll;
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

	/**
	 * recursively traverses the tree and prints the values in the nodes
	 * @param subroot root of tree to be traversed
	 */
	private void orderedPrint(BSTNode<T> subroot){
		if(subroot != null){
			orderedPrint(subroot.llink);
			System.out.println(subroot.key +  "");
			orderedPrint(subroot.rlink);
		}
	}

}