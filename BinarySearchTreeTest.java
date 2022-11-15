package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class HopeCrisafiBSTTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree<String> bst;

    @Before
    public void setup() throws Exception {
        bst = new BinarySearchTree<String>();
    }

    @After
    public void tearDown() throws Exception {
        bst = null;
    }

    @Test//Tests BST constructor
    public void testConstructor(){
        assertEquals("", bst.toString());
    }

    @Test //Tests insert on an empty tree.  New node becomes root.
    public void testBstInsertEmpty(){
        bst.insert("A");
        assertEquals("(  A  )", bst.toString());
    }

    @Test //Tests insert depth 1
    public void testInsertDepth1(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");

        assertEquals("((  A  )  B  (  C  ))", bst.toString());
    }

    @Test //Tests insert depth 2
    public void testInsertDepth2(){
        bst.insert("C");
        bst.insert("E");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("D");

        assertEquals("(((  A  )  B  )  C  ((  D  )  E  (  F  )))", bst.toString());
    }

    @Test //Tests insert values greater than the last
    public void testBstInsertGreater(){
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.insert("D");
        bst.insert("E");
        bst.insert("F");
        bst.insert("G");

        assertEquals("(  A  (  B  (  C  (  D  (  E  (  F  (  G  )))))))", bst.toString());
    }

    @Test //Tests insert values less than the last
    public void testBstInsertLess(){
        bst.insert("G");
        bst.insert("F");
        bst.insert("E");
        bst.insert("D");
        bst.insert("C");
        bst.insert("B");
        bst.insert("A");

        assertEquals("(((((((  A  )  B  )  C  )  D  )  E  )  F  )  G  )", bst.toString());
    }

    @Test //Tests insert; inserts a value that is the same as the root
    public void testInsertDuplicate(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("B");

        assertEquals("((  A  (  B  ))  B  (  C  ))", bst.toString());
    }

    @Test //Tests insert; inserts a value that is the same as the highest value
    public void testInsertDuplicateHighestValue(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");

        bst.insert("C");

        assertEquals("((  A  )  B  ((  C  )  C  ))", bst.toString());
    }

    @Test //Tests insert; inserts a value that is the same as the lowest value
    public void testInsertDuplicateLowestValue(){
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");

        bst.insert("A");

        assertEquals("(((  A  )  A  )  B  (  C  ))", bst.toString());
    }

    @Test //Tests insert; inserts a duplicate that appears in the first depth
    public void testInsertDuplicateDepth2(){
        bst.insert("C");
        bst.insert("E");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("D");

        bst.insert("B");

        assertEquals("(((  A  (  B  ))  B  )  C  ((  D  )  E  (  F  )))", bst.toString());
    }

    @Test //Tests insert; inserts a duplicate that appears twice
    public void testInsertDoubleDuplicateDepth2(){
        bst.insert("C");
        bst.insert("E");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("D");

        bst.insert("B");
        bst.insert("B");

        assertEquals("(((  A  ((  B  )  B  ))  B  )  C  ((  D  )  E  (  F  )))", bst.toString());
    }

    @Test //Tests insert; inserts a duplicate that appears twice
    public void testInsertNotAGoodTree(){
        bst.insert("C");
        bst.insert("B");
        bst.insert("B");
        bst.insert("C");
        bst.insert("B");
        bst.insert("C");

        assertEquals("((((  B  )  B  )  B  ((  C  )  C  ))  C  )", bst.toString());
    }

    @Test //Tests insert; inserts a lowercase a and f (the lowest and highest capital letters)
    public void testInsertLowercase(){
        bst.insert("C");
        bst.insert("E");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("D");

        bst.insert("a");
        bst.insert("f");

        assertEquals("(((  A  )  B  )  C  ((  D  )  E  (  F  (  a  (  f  )))))", bst.toString());
    }

    @Test //Tests insert; half the letters are lowercase.  Lowercase letters have higher ASCII value than uppercase
    public void testInsertHalfLowercase(){
        bst.insert("C");
        bst.insert("e");
        bst.insert("B");
        bst.insert("f");
        bst.insert("A");
        bst.insert("d");

        assertEquals("(((  A  )  B  )  C  ((  d  )  e  (  f  )))", bst.toString());
    }

    @Test //Tests delete; deletes the greatest value.
    public void testDeleteGreatestValue(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        bst.delete("G");

        assertEquals("(((  A  )  B  (  C  ))  D  ((  E  )  F  ))", bst.toString());
    }

    @Test //Tests delete; deletes the greatest value.
    public void testDeleteLowestValue(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        bst.delete("A");

        assertEquals("((  B  (  C  ))  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test //Tests delete, deletes the root node of a subtree. Greatest val below subroot becomes new subroot
    public void testDeleteSubRoot(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        bst.delete("B");

        assertEquals("(((  A  )  C  )  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test //Tests delete, deletes the root node. Greatest val becomes root
    public void testDeleteRoot(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        bst.delete("D");

        assertEquals("(((  A  )  B  (  C  ))  G  ((  E  )  F  ))", bst.toString());
    }

    @Test //Tests delete, tries to delete something not in the tree. Does nothing
    public void testDeleteNotInTree(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        bst.delete("X");

        assertEquals("(((  A  )  B  (  C  ))  D  ((  E  )  F  (  G  )))", bst.toString());
    }

    @Test //Tests search; searches for a value that is in the tree
    public void testSearchInTree(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertTrue(bst.search("C"));
    }

    @Test //Tests search; searches for a value that is not in the tree
    public void testSearchNotInTree(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertFalse(bst.search("X"));
    }

    @Test //Tests search; tries to search an empty tree
    public void testSearchEmptyTree(){

        assertFalse(bst.search("X"));
    }

    @Test //Tests search; searches for the greatest value
    public void testSearchGreatestValue(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertTrue(bst.search("F"));
    }

    @Test //Tests search; searches for the lowest value
    public void testSearchLowestValue(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertTrue(bst.search("A"));
    }

    @Test //Tests search; searches for the lowercase of an uppercase letter (should return false, case-sensitive)
    public void testSearchLowercase(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertFalse(bst.search("a"));
    }

    @Test //Tests findMax; finds the highest value in the tree
    public void testFindMax(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");


        assertEquals("G", bst.findMax());
    }

    @Test //Tests findMax; tries to find the max value on an empty tree
    public void testFindMaxEmpty(){

        assertNull(bst.findMax());
    }

    @Test //Tests findMin; finds the lowest value in the tree
    public void testFindMin(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");


        assertEquals("A", bst.findMin());
    }

    @Test //Tests findMin; tries to find the smallest value on an empty tree
    public void testFindMinEmpty(){

        assertNull(bst.findMin());
    }

    @Test //Tests search; searches for the greatest value
    public void testPrintTree(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        //bst.printPreorder();
    }

    @Test //Tests search; searches for the greatest value
    public void testSize(){
        bst.insert("D");
        bst.insert("B");
        bst.insert("F");
        bst.insert("A");
        bst.insert("C");
        bst.insert("E");
        bst.insert("G");

        assertEquals(7, bst.size());
    }


}
