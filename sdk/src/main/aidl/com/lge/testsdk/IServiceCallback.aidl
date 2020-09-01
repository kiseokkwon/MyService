// IServiceCallback.aidl
package com.lge.testsdk;

// Declare any non-default types here with import statements

interface IServiceCallback {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onMessageReceived(int what, in Bundle bundle);
}
