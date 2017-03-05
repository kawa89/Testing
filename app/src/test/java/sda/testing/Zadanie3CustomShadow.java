package sda.testing;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class Zadanie3CustomShadow {

    // Napisz testy, które sprawdzą ( przydadzą się @Implements(Resources.class), @Config(shadows = ) )
    // 1. poprawność Stringa 'numberOfSongsAvailable' w liczbie mnogiej
    // 2. Nadpiszesz za pomocą własnej implementacji klasy ShadowResources, metodę pobierania QuantityString'a, tak aby zwracała tekst "Some String" - tylko
    //    ale tylko dla QuantityString'a o id numberOfSongsAvailable. Dodaj inny QuantityString do resource'ów i sprawdź, czy on się nie nadpisuje.


}

