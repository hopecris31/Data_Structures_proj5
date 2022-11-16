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
    }


}
