package com.lge.testsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.lge.testsdk.MyServiceProvider.OnServiceEventListener;

public class MyServiceProviderImpl {
    private static final String TAG = "SDK_PROVIDER";
    static final String SERVICE_NAME = "com.lge.testservice";
    static final String PACKAGE_NAME = "com.lge.testservice";

    static IServiceInterface mIServiceInterface;
    static OnServiceEventListener mOnServiceEventListener;
    static MyServiceInterfaceImpl mServiceInterfaceImpl;
    static boolean isConnected = false;


    public static void setOnServiceEventListener(OnServiceEventListener listener) {
        mOnServiceEventListener = listener;
    }

    public static boolean connect(Context context) {
        Log.d(TAG, "connect");
        if(isConnected) return false;

        Intent intent = new Intent(SERVICE_NAME);
        intent.setPackage(PACKAGE_NAME);
        return context.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public static void disconnect(Context context) {
        Log.d(TAG, "disconnect");
        if(!isConnected) return;

        if(mServiceConnection != null) {
            context.unbindService(mServiceConnection);
        }

        isConnected = false;
        if(mOnServiceEventListener != null) {
            mOnServiceEventListener.onDisconnected();
        }
    }

    static final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIServiceInterface = IServiceInterface.Stub.asInterface(service);
            if(mServiceInterfaceImpl == null) {
                mServiceInterfaceImpl = new MyServiceInterfaceImpl(mIServiceInterface);
            }

            try {
                mIServiceInterface.registerCallback(mServiceInterfaceImpl.getServiceCallback());
            }
            catch (RemoteException e) {
                e.printStackTrace();
                return;
            }

            if(mOnServiceEventListener != null) {
                mOnServiceEventListener.onConnected(mServiceInterfaceImpl);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            try {
                mIServiceInterface.unregisterCallback(mServiceInterfaceImpl.getServiceCallback());
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }

            if(mOnServiceEventListener != null) {
                mOnServiceEventListener.onDisconnected();
            }

            mServiceInterfaceImpl = null;
            mIServiceInterface = null;
            isConnected = false;
        }
    };
}
