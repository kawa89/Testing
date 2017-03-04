package sda.testing;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Zadanie6 {

    // Zamień metody sprawdzające na metodę pojedynczą assertThat z klasy org.junit.Assert :

    private static final Map<String, Double> map;

    static {
        map = new HashMap<>();
        map.put("a", 1.0d);
        map.put("b", 2.0d);
    }

    private List<Integer> list = Arrays.asList(5, 2, 4);
    private List<Integer> nullList;
    private String str = "startMiddleEnd";
    private String[] array = {"abc", "def", "ghi"};

    // rozwiązanie
    @Test
    public void test1_oldImplementation() {
        assertEquals(3, list.size());
    }

    @Test
    public void test1_newImplementation() {

    }

    @Test
    public void test2_oldImplementation() {
        assertEquals(5, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
        assertEquals(4, (int) list.get(2));
    }

    @Test
    public void test2_newImplementation() {

    }

    @Test
    public void test3_oldImplementation() {
        assertTrue(list.contains(4));
        assertTrue(list.contains(2));
        assertTrue(list.contains(5));
    }

    @Test
    public void test3_newImplementation() {

    }

    @Test
    public void test4_oldImplementation() {
        for (int element : list) {
            assertTrue(element > 1);
        }
    }

    @Test
    public void test4_newImplementation() {

    }

    @Test
    public void test5_oldImplementation() {
        assertTrue(str.startsWith("start"));
        assertTrue(str.contains("Middle"));
        assertTrue(str.endsWith("End"));
    }

    @Test
    public void test5_oldImplementation_oneLine() {
        assertTrue(str.startsWith("start") && str.contains("Middle") && str.endsWith("End"));
    }

    @Test
    public void test5_newImplementation() {

    }

    @Test
    public void test6_oldImplementation() {
        boolean result = false;
        for (String element : array) {
            if (element.equals("abc")) {
                result = true;
                break;
            }
        }
        assertTrue("No matching item found", result);
    }

    @Test
    public void test6_newImplementation() {

    }

    // tutaj wypełnij starą implementację
    @Test
    public void test7_oldImplementation() {

    }

    @Test
    public void test7_newImplementation() {
        assertThat(map, hasValue(1.0d));
    }

    @Test
    public void test8_oldImplementation() {
        boolean result = false;
        for (String element : map.keySet()) {
            if (element.equals("a")) {
                result = true;
                break;
            }
        }
        assertTrue("No matching key found", result);
    }

    @Test
    public void test8_newImplementation() {

    }

    @Test
    public void test9_oldImplementation() {
        assertNull(nullList);
    }

    @Test
    public void test9_newImplementation() {

    }
}