package com.nazran.retrofit.threading;

import android.os.Handler;
import android.os.Looper;

import com.nazran.retrofit.domain.executor.MainThread;

/**
 * This class makes sure that the runnable we provide will be run on the main UI thread.
 * <p/>
 *
 */

public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;

    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }

        return sMainThread;
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
