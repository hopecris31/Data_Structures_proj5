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
        pl = new Pagelist<>("Test");
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
        assertEquals("Test {A, B, C}", pl.toString());
    }

    @Test //Tests add; adds to an empty pagelist
    public void testAddEmpty(){
        pl.add("A");


        assertEquals(1, pl.size());
        assertEquals("Test {A}", pl.toString());
    }

    @Test //Tests add; tries to add a duplicate element. should not add
    public void testAddDuplicate(){
        pl.add("A");
        pl.add("B");

        pl.add("A");

        assertEquals(2, pl.size());
        assertEquals("Test {A, B}", pl.toString());
    }

    @Test //Tests add; tries to add to a full pagelist. should not add
    public void testAddFull(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        pl.add("X");

        assertEquals(4, pl.size());
        assertEquals("Test {A, B, C, D}", pl.toString());
    }

    @Test //Tests remove;
    public void testRemove(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        pl.remove("A");

        assertEquals(3, pl.size());
        assertEquals("Test {B, C, D}", pl.toString());
    }

    @Test //Tests remove; tries to remove an element not in the pagelist
    public void testRemoveNotInPagelist(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        pl.remove("X");

        assertEquals(4, pl.size());
        assertEquals("Test {A, B, C, D}", pl.toString());
    }

    @Test //Tests remove; tries to remove on an empty pagelist
    public void testRemoveEmpty(){

        pl.remove("A");

        assertEquals(0, pl.size());
        assertEquals("Test {}", pl.toString());
    }

    @Test //Tests size; tested on an empty pagelist
    public void testSizeEmpty(){
        assertEquals(0, pl.size());
    }

    @Test //Tests size; tested on pagelist with size 3
    public void testSize(){
        pl.add("A");
        pl.add("B");
        pl.add("C");

        assertEquals(3, pl.size());
    }

    @Test //Tests contains; pagelist contains element
    public void testContainsTrue(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        assertTrue(pl.contains("B"));
    }

    @Test //Tests contains; pagelist does not contain element
    public void testContainsFalse(){
        pl.add("A");
        pl.add("B");
        pl.add("C");
        pl.add("D");

        assertFalse(pl.contains("X"));
    }

    @Test //Tests contains; pagelist is empty
    public void testContainsEmpty(){

        assertFalse(pl.contains("X"));
    }

}
