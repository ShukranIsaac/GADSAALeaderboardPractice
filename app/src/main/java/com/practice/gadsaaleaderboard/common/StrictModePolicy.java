package com.practice.gadsaaleaderboard.common;

import android.os.StrictMode;

public class StrictModePolicy {
    private static StrictModePolicy sModePolicy;

    private StrictModePolicy() { }

    public static synchronized StrictModePolicy getInstance() {
        if (sModePolicy == null)
            sModePolicy = new StrictModePolicy();

        return sModePolicy;
    }

    public static void getThreadPolicy() {
        StrictMode.setThreadPolicy(new StrictMode
                .ThreadPolicy.Builder()
//                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
    }

    public static void getVmPolicy() {
        StrictMode.setVmPolicy(new StrictMode
                .VmPolicy.Builder()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }
}
