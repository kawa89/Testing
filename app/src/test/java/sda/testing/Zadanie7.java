package sda.testing;

import org.junit.Test;

public class Zadanie7 {

    // Napisz własny Matcher (rozszerz klasę TypeSafeMatcher), który sprawdza Stringi do podanego regex'u

    String REGEX = "a*b*c*";
    String shouldPass = "aabbcc";
    String shouldFail = "aaccaa";

    // rozwiązanie
    @Test
    public void test1() {
//        assertThat(shouldPass, new RegexMatcher(REGEX));
//        assertThat(shouldFail, not(new RegexMatcher(REGEX)));
    }

}