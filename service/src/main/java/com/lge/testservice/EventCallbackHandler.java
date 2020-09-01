package com.lge.testservice;

import android.os.Bundle;
import android.os.RemoteCallbackList;

import com.lge.testsdk.IServiceCallback;

public class EventCallbackHandler {

    static EventCallbackHandler mInstance = new EventCallbackHandler();

    private EventCallbackHandler() {}

    public static EventCallbackHandler getInstance() {
        return mInstance;
    }

    final RemoteCallbackList<IServiceCallback> mIServiceCallbackList = new RemoteCallbackList<>();

    public boolean registerCallback(IServiceCallback cb) {
        return mIServiceCallbackList.register(cb);
    }

    public boolean unregisterCallback(IServiceCallback cb) {
        return mIServiceCallbackList.unregister(cb);
    }

    public void sendCallbackEvent(int what, Bundle bundle) {
        int receiverCount = mIServiceCallbackList.beginBroadcast();
        for (int i = 0; i < receiverCount; i++) {
            try {
                IServiceCallback cb = mIServiceCallbackList.getBroadcastItem(i);
                cb.onMessageReceived(what, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mIServiceCallbackList.finishBroadcast();
    }
}
