package com.lge.testsdk;

import android.content.Context;

public final class MyServiceProvider {
    private MyServiceProvider() {}

    public interface OnServiceEventListener {
        void onConnected(MyServiceInterface iface);
        void onDisconnected();
    }

    public static void setOnServiceEventListener(OnServiceEventListener listener) {
        MyServiceProviderImpl.setOnServiceEventListener(listener);
    }

    public static boolean connect(Context context) {
        return MyServiceProviderImpl.connect(context);
    }

    public static void disconnect(Context context) {
        MyServiceProviderImpl.disconnect(context);
    }
}
