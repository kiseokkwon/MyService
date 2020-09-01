package com.lge.testsdk;

public interface MyServiceInterface {
    interface OnEventListener {
        void onHelloRequested();
    }
    void setOnEventListener(OnEventListener listener);

    void hello();
    void goodBye();
}
