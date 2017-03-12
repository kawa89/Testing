package sda.testing;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import sda.testing.activity.MainActivity;

public class Zadanie7MainActivityLifecycle {

    // Napisz testy, które sprawdzą:
    // 1. sprawdź czy Button o id button4 jest niewidoczny, zmien orientacje, sprawdz czy jest widoczny,
    // kliknij, sprawdz czy tekst sie zmienił ( użyj activityTestRule.getActivity().setRequestedOrientation(), withEffectiveVisibility

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1() throws Exception {

    }
}