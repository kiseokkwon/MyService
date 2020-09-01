package com.lge.testapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.lge.testsdk.Log;
import com.lge.testsdk.MyServiceInterface;
import com.lge.testsdk.MyServiceProvider;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "APP";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "onCreate()");
    setContentView(R.layout.activity_main);

    MyServiceProvider.connect(this);
    MyServiceProvider.setOnServiceEventListener(new MyServiceProvider.OnServiceEventListener() {
      @Override
      public void onConnected(MyServiceInterface myServiceInterface) {
        myServiceInterface.setOnEventListener(new MyServiceInterface.OnEventListener() {
          @Override
          public void onHelloRequested() {
            Log.d(TAG, "onHelloRequested()");
          }
        });
        myServiceInterface.hello();
      }

      @Override
      public void onDisconnected() {

      }
    });
  }

  @Override
  public void onConfigurationChanged(@NonNull Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    //Log.d(TAG, "onConfigurationChanged()");
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();
    //Log.d(TAG, "onPostResume()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    //Log.d(TAG, "onResume()");
  }

  @Override
  protected void onStart() {
    super.onStart();
    //Log.d(TAG, "onStart()");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    //Log.d(TAG, "onDestroy()");
  }
}
