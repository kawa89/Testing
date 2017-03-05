package sda.testing.service;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import sda.testing.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class Zadanie6SampleIntentService {

    // Napisz testy, które sprawdzą, czy (wykorzystaj do inicjalizacji serwisu ServiceController i Robolectric.buildService())
    // 1. przetestuj działanie IntentService'u SampleIntentService. Wywołaj onHandleIntent() z odpowiednio przygotowanym intentem.
    //    Do sprawdzenia SharedPreferences wykorzystaj klasę RoboSharedPreferences

}
