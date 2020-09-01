// IServiceInterface.aidl
package com.lge.testsdk;

import com.lge.testsdk.IServiceCallback;
// Declare any non-default types here with import statements

interface IServiceInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    boolean registerCallback(in IServiceCallback cb);
    boolean unregisterCallback(in IServiceCallback cb);

    void sendMessage(int what, in Bundle bundle);
}
