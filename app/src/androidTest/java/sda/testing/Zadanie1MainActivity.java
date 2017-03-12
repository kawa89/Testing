package sda.testing;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import sda.testing.activity.MainActivity;


public class Zadanie1MainActivity {

    // Napisz testy, które sprawdzą, czy :
    // 1. Czy na View z Id R.id.text tekst jest ustawiony na domyślny
    // 2. Czy tekst w TextView jest poprawny po kliknięciu na pierwszy Button
    // 3. Czy tekst w TextView jest poprawny po kliknięciu kilku Button'ów (wyszukaj Button'a po tekście na nim)
    // 4. Czy po pokazaniu Menu z Action Bar'a są widoczne teksty z MenuItem1 i MenuItem2 ( użyj withText() i withEffectiveVisibility)
    // 5. Czy kliknięcie w pierwszy Menu item spowoduje pojawienie się Toast'a
    // 6. Czy View z tekstem "Testing" ma rodzica o id R.id.toolbar
    // 7. Czy Button 2 jest na lewo od Button 3
    // 8. Czy View z ustawionym contentDescription "to jest button 3" ma jest tekst Button 3 ( użyj withContentDescription)
    // 9. Czy wszystkie Buttony mają id R.id.button3 - test powinien failować. Sprawdź jak wyglądają logi Espresso. Zignoruj poźniej test.
    // 10. Wykorzystaj test 9 - sprecyzuj wyszukiwanie view dodatkowo po tekście ( użyj allOf )
    // 11. Sprawdź Toast po kliknięciu w 10 element RecyclerView ( użyj RecyclerViewActions.actionOnItemAtPosition )

    // rozwiązanie
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1() throws Exception {

    }

    @Test
    public void test2() throws Exception {

    }

    @Test
    public void test3() throws Exception {

    }

    @Test
    public void test4() throws Exception {

    }

    @Test
    public void test5() throws Exception {


        // sprawdzenie Toast'a
//        onView(withText("Clicked Item 1")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void test6() throws Exception {

    }

    @Test
    public void test7() throws Exception {

    }

    @Test
    public void test8() throws Exception {

    }

    @Test
    public void test9() throws Exception {

    }

    @Test
    public void test10() throws Exception {

    }

    @Test
    public void test11() throws Exception {


        // sprawdzeni Toast'a
//        onView(withText("10 : Android10")).inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow().getDecorView()))))
//                .check(matches(isDisplayed()));
    }
}