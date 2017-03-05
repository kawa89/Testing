package sda.testing;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class Zadanie1MainActivity {

    // Napisz testy, które sprawdzą, czy :
    // 1. Czy tekst w TextView jest ustawiony na domyślny
    // 2. Czy tekst w TextView jest poprawny po kliknięciu na pierwszy Button
    // 3. Czy tekst w TextView jest poprawny po kliknięciu kilku Button'ów
    // 4. Czy Menu na actionBar ma poprawne tytuły (teksty) - przydatne shadowOf(activity)
    // 5. Czy kliknięcie w pierwszy Menu item spowoduje pojawienie się Toast'a - przydatna metoda shadowOf(activity) i klasa ShadowToast
    // 6. Czy domyślny tytuł ActionBar'a jest poprawny
    // 7. Czy niemiecki tytuł ActionBar'a jest poprawny


}