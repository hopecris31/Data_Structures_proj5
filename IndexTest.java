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
        index = new Index<>("Test");
    }

    @After
    public void tearDown() throws Exception {
        index = null;
    }

    @Test
    public void testInsert(){
        index.insert("hello");
        index.insert("world");

        assertEquals("( hello {} ) world {} ))", index.toString());
    }

    @Test
    public void testInsertDuplicate(){
        index.insert("hello");
        index.insert("world");

        index.insert("hello");

        assertEquals("( hello {} ) world {} ))", index.toString());
    }

    @Test
    public void testInsertFullPagelist(){
        index.insert("hello");
        index.insert("world");
        index.insert("Hello");
        index.insert("World");

        index.insert("hello");

        assertEquals(4, index.size());
    }

    @Test
    public void testAddToDict(){

    }

}
