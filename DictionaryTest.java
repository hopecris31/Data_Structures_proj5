package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class DictionaryTest {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    public Dictionary dict;

    @Before
    public void setup() throws Exception {
        dict = new Dictionary();
    }

    @After
    public void tearDown() throws Exception {
        dict = null;
    }

    @Test
    public void testInsert(){
        dict.insert("hello");
        dict.insert("world");
        dict.insert("dog");

        System.out.println(dict);

        assertEquals("1) dog\n" +
                "2) world\n" +
                "3) hello", dict.toString());
    }

    @Test
    public void testRemove(){
        dict.insert("hello");
        dict.insert("world");
        dict.insert("dog");

        dict.remove("dog");

        System.out.println(dict);

        assertEquals("1) world\n" +
                "2) hello", dict.toString());
    }

    @Test
    public void testContains(){
        dict.insert("hello");
        dict.insert("world");
        dict.insert("dog");

        System.out.println(dict);

        assertTrue(dict.contains("dog"));
    }

    @Test
    public void testContainsFalse(){
        dict.insert("hello");
        dict.insert("world");
        dict.insert("dog");

        System.out.println(dict);

        assertFalse(dict.contains("cat"));
    }

}
