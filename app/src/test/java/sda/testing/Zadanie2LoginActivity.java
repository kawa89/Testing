package sda.testing;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class Zadanie2LoginActivity {

    // Napisz testy, które sprawdzą ( przydadzą się metody shadowOf(RuntimeEnvironment.application), getNextStartedActivity(), performClick() )
    // 1. czy po poprawnym zalogowaniu nie pojawią się informacje o błędach na EditText'ach
    // 2. czy po poprawnym zalogowaniu wystartuje się MainActivity
    // 3. scenariusz zalogowania się bez podanych danych do logowania
    // 4. scenariusz zalogowania się bez z błędnymi danymi do logowania


}