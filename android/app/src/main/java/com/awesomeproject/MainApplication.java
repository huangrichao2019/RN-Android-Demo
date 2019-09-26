package com.awesomeproject;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import com.growingio.android.plugin.rn.GrowingIOPackage;
import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.gtouch.GrowingTouch;
import com.growingio.android.sdk.gtouch.config.GTouchConfig;
import com.growingio.android.sdk.gtouch.listener.EventPopupListener;


public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new GrowingIOPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };
  private String TAG = "RN-GTouch";

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    GrowingIO.startWithConfiguration(this, new Configuration()
            .setTestMode(BuildConfig.DEBUG)
            .setDebugMode(BuildConfig.DEBUG)
            .setChannel("HangZhou")
    );

    GrowingTouch.startWithConfig(this, new GTouchConfig()
            .setEventPopupShowTimeout(5000)
            .setEventPopupEnable(true)
            .setPushEnable(false)
            .setDebugEnable(BuildConfig.DEBUG).
                    setUploadExceptionEnable(BuildConfig.DEBUG).
            setEventPopupListener(new EventPopupListener(){
              @Override
              public void onLoadSuccess(String eventId, String eventType) {
                Log.d(TAG, "onLoadSuccess: eventId = " + eventId + ", eventType = " + eventType);
              }

              @Override
              public void onLoadFailed(String eventId, String eventType, int errorCode, String description) {
                Log.d(TAG, "onLoadFailed: eventId = " + eventId + ", eventType = " + eventType);

              }

              @Override
              public boolean onClicked(String eventId, String eventType, String openUrl) {
                Log.d(TAG, "onClicked: eventId = " + eventId + ", eventType = " + eventType);
                return false;
              }

              @Override
              public void onCancel(String eventId, String eventType) {
                Log.d(TAG, "onCancel: eventId = " + eventId + ", eventType = " + eventType);

              }

              @Override
              public void onTimeout(String eventId, String eventType) {
                Log.d(TAG, "onTimeout: eventId = " + eventId + ", eventType = " + eventType);
              }
            })
    );


  }
}
