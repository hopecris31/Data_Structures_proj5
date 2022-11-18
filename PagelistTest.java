package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;



public class PagelistTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    public Pagelist pl;

    @Before
    public void setup() throws Exception {
        pl = new Pagelist("Test");
    }

    @After
    public void tearDown() throws Exception {
        pl = null;
    }

    @Test //Tests add;
    public void testAdd(){
        pl.add(1);
        pl.add(2);
        pl.add(3);

        assertEquals(3, pl.size());
        assertEquals("Test {1, 2, 3}", pl.toString());
    }

    @Test //Tests add; adds to an empty pagelist
    public void testAddEmpty(){
        pl.add(1);


        assertEquals(1, pl.size());
        assertEquals("Test {1}", pl.toString());
    }

    @Test //Tests add; tries to add a duplicate element. should not add
    public void testAddDuplicate(){
        pl.add(1);
        pl.add(2);

        pl.add(1);

        assertEquals(2, pl.size());
        assertEquals("Test {1, 2}", pl.toString());
    }

    @Test //Tests add; tries to add to a full pagelist. should not add
    public void testAddFull(){
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);

        pl.add(9);

        assertEquals(4, pl.size());
        assertEquals("Test {1, 2, 3, 4}", pl.toString());
    }

    @Test //Tests remove;
    public void testRemove(){
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);

        pl.remove(1);
        System.out.println(pl.toString());

        assertEquals(3, pl.size());
        assertEquals("Test {2, 3, 4}", pl.toString());
    }

    @Test //Tests remove; tries to remove an element not in the pagelist
    public void testRemoveNotInPagelist(){
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);

        pl.remove(9);

        assertEquals(4, pl.size());
        assertEquals("Test {1, 2, 3, 4}", pl.toString());
    }

    @Test //Tests remove; tries to remove on an empty pagelist
    public void testRemoveEmpty(){

        pl.remove(1);

        assertEquals(0, pl.size());
        assertEquals("Test {}", pl.toString());
    }

    @Test //Tests size; tested on an empty pagelist
    public void testSizeEmpty(){
        assertEquals(0, pl.size());
    }

    @Test //Tests size; tested on pagelist with size 3
    public void testSize(){
        pl.add(1);
        pl.add(2);
        pl.add(3);

        assertEquals(3, pl.size());
    }

    @Test //Tests contains; pagelist contains element
    public void testContainsTrue(){
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);

        assertTrue(pl.contains(2));
    }

    @Test //Tests contains; pagelist does not contain element
    public void testContainsFalse(){
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);

        assertFalse(pl.contains(9));
    }

    @Test //Tests contains; pagelist is empty
    public void testContainsEmpty(){

        assertFalse(pl.contains(9));
    }

    @Test //Tests contains; pagelist is empty
    public void testCompareTo(){
        Pagelist pl2 = new Pagelist("further");
        Pagelist pl3 = new Pagelist("try");
        System.out.println(pl2.compareTo(pl3));
    }

}
