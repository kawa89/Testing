package sda.testing;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class Zadanie7MainActivityLifecycle {

    // Napisz testy, które sprawdzą, czy ( przyda się ActivityController<MainActivity> = Robolectric.buildActivity(MainActivity.class) ):
    // 1. czy po kliknieciu przycisku 1 TextView będzie mieć ustawiony tekst "Button 1", następnie po zasymulowaniu rotacji,
    // czy tekst w TextView powróci na domyślny.


}