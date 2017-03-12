package sda.testing.service;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ServiceController;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboSharedPreferences;

import sda.testing.BuildConfig;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class Zadanie6SampleIntentService {

    // Napisz testy, które sprawdzą, czy (wykorzystaj do inicjalizacji serwisu ServiceController i Robolectric.buildService())
    // 1. przetestuj działanie IntentService'u SampleIntentService. Wywołaj onHandleIntent() z odpowiednio przygotowanym intentem.
    //    Do sprawdzenia SharedPreferences wykorzystaj klasę RoboSharedPreferences

    // rozwiązanie
    private SampleIntentService service;
    private ServiceController<SampleIntentService> controller;

    @Before
    public void setUp() {
        controller = Robolectric.buildService(SampleIntentService.class);
        service = controller.create().get();
    }

    @Test
    public void test1() {
        Application application = RuntimeEnvironment.application;
        RoboSharedPreferences preferences = (RoboSharedPreferences) application.getSharedPreferences("example", Context.MODE_PRIVATE);
        Intent intent = new Intent(application, SampleIntentService.class);
        intent.putExtra("INTENT_KEY", "data");

        service.onHandleIntent(intent);

        assertEquals("data", preferences.getString("SHARED_PREF_KEY", ""));
    }

    @After
    public void tearDown() {
        controller.destroy();
    }
}
