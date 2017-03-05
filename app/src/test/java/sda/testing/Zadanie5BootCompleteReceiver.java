package sda.testing;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class Zadanie5BootCompleteReceiver {
    private ShadowApplication application;

    // Napisz testy, które sprawdzą, czy ( przyda się metoda ShadowApplication.getInstance(), hasReceiverForIntent()):
    // 1. Czy nasz aplikacja ma zarejestrowany receiver dla akcji "ACTION_BOOT_COMPLETED"
    // 2. Czy nasz aplikacja ma zarejestrowany BootCompleteReceiver, wsród listy zarejestrowanych receiverów (za pomocą nazwy klasy)
    // (przyda się getRegisteredReceivers() i .getBroadcastReceiver() na obiektach ShadowApplication.Wrapper)
    // 3. Dla ambitnych - po wykonaniu zadania 2, przepisz je z wykorzystaniem własnego TypeSafeMatcher'a, który jako parametr przyjmuje klasę Class,
    //  a działa na obiekcie List<ShadowApplication.Wrapper>.


}
