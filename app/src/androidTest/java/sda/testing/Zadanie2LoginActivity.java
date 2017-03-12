package sda.testing;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import sda.testing.activity.LoginActivity;

public class Zadanie2LoginActivity {

    // Napisz testy, które sprawdzą
    // 1. czy po poprawnym zalogowaniu EditText'y do loginu i hasła do logowania są niedostępne (użyj doesNotExist())
    // 2. czy po poprawnym zalogowaniu wystartuje się MainActivity (użyj Intents.intended(), do wyszukania view użyj withID, withHint, withText)
    // 3. Czy pojawi się informacja o pustym polu email (hasErrorText - na odpowiednim view)
    // 4. Czy pojawi się informacja o pustym polu password (hasErrorText - na odpowiednim view)
    // 5. scenariusz zalogowania się bez z błędnymi danymi do logowania - sprawdz z pomocą hasErrorText

    // rozwiązanie
    @Rule
    public IntentsTestRule<LoginActivity> activityTestRule = new IntentsTestRule<>(LoginActivity.class);

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

        // Dla ambitnych - Napisz własną metodę withNullError zwracającą odpowiedni Matcher dla view R.id.email sprawdzającą null'owy getError().
        // onView(withId(R.id.email)).check(matches(withNullError()));
    }


    @Test
    public void test5() throws Exception {

    }

}