package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class IndexTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    public Index index;

    @Before
    public void setup() throws Exception {
        index = new Index();
    }

    @After
    public void tearDown() throws Exception {
        index = null;
    }

    @Test
    public void makeEntry(){
        index.makeEntry("hello", 1);

        assertEquals("(  hello {}  )", index.toString());
    }

    @Test
    public void testInsertDuplicate(){
        index.makeEntry("hello", 1);
        index.makeEntry("world", 1);

        index.makeEntry("hello", 1);

        assertEquals("(  hello {}  (  world {}  ))", index.toString());
    }

    @Test
    public void testInsertFullPagelist(){
        index.makeEntry("hello", 1);
        index.makeEntry("world", 1);
        index.makeEntry("Hello", 1);
        index.makeEntry("World", 1);

        index.makeEntry("hello", 1);
        System.out.println(index);

        assertEquals(4, index.size());
    }

    @Test
    public void testRemove(){
        index.makeEntry("hello", 1);
        index.makeEntry("world", 1);
        index.makeEntry("Hello", 1);
        index.makeEntry("World", 1);

        index.delete("hello");
        System.out.println(index);

        assertEquals(3, index.size());
    }

    @Test
    public void testRemoveEmpty(){
        index.makeEntry("hello", 1);
        index.makeEntry("world", 1);
        index.makeEntry("Hello", 1);
        index.makeEntry("World", 1);

        index.delete("hello");
        System.out.println(index);

        assertEquals(3, index.size());
    }

    @Test
    public void testaddPageNum(){
        index.makeEntry("hello", 1);
        index.makeEntry("world", 1);

        index.addPageNum(3, "hello");
        index.addPageNum(3, "hello");
        index.addPageNum(4, "hello");
        index.addPageNum(5, "hello");
        index.addPageNum(6, "hello");
        index.addPageNum(7, "hello");
        index.addPageNum(7, "world");


        System.out.println(index);

    }

    @Test
    public void testWordContainsPage(){
        index.makeEntry("hello", 1);
        index.makeEntry("world", 1);

        index.addPageNum(3, "hello");
        index.addPageNum(3, "hello");
        index.addPageNum(4, "hello");

        assertTrue(index.wordContainsPage(3, "hello"));
    }

}
