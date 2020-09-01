package com.lge.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.lge.testsdk.IServiceCallback;
import com.lge.testsdk.IServiceInterface;
import com.lge.testsdk.Log;

public class MyService extends Service {
    private static final String TAG = "SERVICE";
    final IServiceInterface.Stub mBinder = new IServiceInterface.Stub() {
        @Override
        public boolean registerCallback(IServiceCallback iServiceCallback) throws RemoteException {
            return EventCallbackHandler.getInstance().registerCallback(iServiceCallback);
        }

        @Override
        public boolean unregisterCallback(IServiceCallback iServiceCallback) throws RemoteException {
            return EventCallbackHandler.getInstance().unregisterCallback(iServiceCallback);
        }

        @Override
        public void sendMessage(int what, Bundle bundle) throws RemoteException {
            Log.d(TAG, "sendMessage: " + what);
            switch (what) {
                //TODO
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
