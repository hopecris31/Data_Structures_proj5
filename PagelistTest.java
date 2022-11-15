package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;



public class PagelistTest {

    //@Rule
    //public Timeout timeout = Timeout.millis(100);

    public Pagelist<String> pl;

    @Before
    public void setup() throws Exception {
        pl = new Pagelist<>();
    }

    @After
    public void tearDown() throws Exception {
        pl = null;
    }

    @Test //Tests add;
    public void testAdd(){
        pl.add("A");
        pl.add("B");
        pl.add("C");

        assertEquals(3, pl.size());
        assertEquals("( A B C )", pl.toString());
    }

    @Test //Tests add; adds to an empty pagelist
    public void testAddEmpty(){
        pl.add("A");


        assertEquals(1, pl.size());
        assertEquals("( A )", pl.toString());
    }

    @Test //Tests add; tries to add a duplicate element. should not add
    public void testAddDuplicate(){
        pl.add("A");
        pl.add("B");

        pl.add("A");

        assertEquals(2, pl.size());
        assertEquals("( A B )", pl.toString());
    }

    @Test //Tests add; tries to add to a full pagelist. should not add
    public void testAddFull(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        pl.add("X");

        assertEquals(4, pl.size());
        assertEquals("( A B C D )", pl.toString());
    }

    @Test //Tests remove;
    public void testremove(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        pl.remove("A");

        assertEquals(3, pl.size());
        assertEquals("( B C D )", pl.toString());
    }

    @Test //Tests size; tested on an empty pagelist
    public void testSizeEmpty(){
        assertEquals(0, pl.size());
    }

    @Test //Tests size; tested on pagelist with size 3
    public void testSize(){
        assertEquals(3, pl.size());
    }

    @Test //Tests contains; pagelist contains element
    public void testContainsTrue(){


        assertTrue(pl.contains("B"));
    }

}
