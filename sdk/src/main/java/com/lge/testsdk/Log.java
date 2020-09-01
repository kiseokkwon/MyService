package com.lge.testsdk;

public class Log {
  private static final String TAG = "testapp";
  public static void i(String tag, String msg) {
    android.util.Log.i(TAG, tag + " - " + msg);
  }
  public static void d(String tag, String msg) {
    android.util.Log.d(TAG, tag + " - " + msg);
  }
  public static void v(String tag, String msg) {
    android.util.Log.v(TAG, tag + " - " + msg);
  }
  public static void e(String tag, String msg) {
    android.util.Log.e(TAG, tag + " - " + msg);
  }
  public static void e(String tag, String msg, Throwable e) {
    android.util.Log.e(TAG, tag + " - " + msg, e);
  }
  public static void w(String tag, String msg) {
    android.util.Log.w(TAG, tag + " - " + msg);
  }
}
