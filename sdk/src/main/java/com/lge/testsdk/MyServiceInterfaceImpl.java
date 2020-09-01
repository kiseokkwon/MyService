package com.lge.testsdk;

import android.os.Bundle;
import android.os.RemoteException;

import com.lge.testsdk.constants.EventMessage;

public class MyServiceInterfaceImpl implements MyServiceInterface {
    private static final String TAG = "SDK_INTERFACE";
    OnEventListener mOnEventListener;
    IServiceInterface mServiceInterface;

    @Override
    public void setOnEventListener(OnEventListener listener) {
        mOnEventListener = listener;
    }

    public MyServiceInterfaceImpl(IServiceInterface iface) {
        mServiceInterface = iface;
    }

    @Override
    public void hello() {
        Log.i(TAG, "Hello!");
        try {
            Bundle bundle = new Bundle();
            mServiceInterface.sendMessage(EventMessage.SAY_HELLO, bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goodBye() {
        Log.i(TAG, "goodBye!");
        try {
            Bundle bundle = new Bundle();
            mServiceInterface.sendMessage(EventMessage.SAY_GOOD_BYE, bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    IServiceCallback mServiceCallback = new IServiceCallback.Stub() {
        @Override
        public void onMessageReceived(int what, Bundle bundle) throws RemoteException {
            Log.d(TAG, "onMessageReceived()");
            switch (what) {

            }
        }
    };

    public IServiceCallback getServiceCallback() {
        return mServiceCallback;
    }
}
