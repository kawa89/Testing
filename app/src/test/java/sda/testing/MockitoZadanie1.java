package sda.testing;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MockitoZadanie1 {

    // Uzupełnij testy, wykorzystując metodę mock()

    @Test
    public void test1() {
        MyClass test = null;


        assertEquals(test.getUniqueId(), 43);
    }

    @Test
    public void test2() {
        Iterator i = null;


        assertEquals("Mockito jest fajne", i.next() + " " + i.next());
    }

    @Test
    public void test3() {
        Comparable c = null;


        assertEquals(1, c.compareTo("Mockito"));
        assertEquals(2, c.compareTo("Android Studio"));
    }

    @Test
    public void test4() {
        Comparable c = null;

        // użuj jednej metody when!


        assertEquals(-1, c.compareTo(9));
        assertEquals(-1, c.compareTo(-12));
        assertNotEquals(-1, c.compareTo(0.032f));
        assertNotEquals(-1, c.compareTo(2.0d));
        assertNotEquals(-1, c.compareTo(false));
    }

    @Test(expected = MyException.class)
    public void test5() throws IOException {
        // create an configure mock
        OutputStream stream = null;

        // close() powinien wyrzucić wyjątek MyException()


        OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
        streamWriter.close();
    }

    private class MyClass {
        private int uniqueId;

        public MyClass(int i) {
            uniqueId = i;
        }

        int getUniqueId() {
            return uniqueId;
        }
    }

    private class MyException extends IOException {
    }
}