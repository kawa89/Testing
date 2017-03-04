package sda.testing;

import android.content.Context;
import android.content.SharedPreferences;

public class Config {
    private SharedPreferences preferences;

    private Config(Context context) {
        preferences = context.getSharedPreferences(Constants.PREFS_KEY, Context.MODE_PRIVATE);
    }

    public static Config newInstance(Context context) {
        return new Config(context);
    }

    public boolean getIsFirstRun() {
        return preferences.getBoolean(Constants.IS_FIRST_RUN, true);
    }

    public void setIsFirstRun(boolean firstRun) {
        preferences.edit().putBoolean(Constants.IS_FIRST_RUN, firstRun).apply();
    }

}
