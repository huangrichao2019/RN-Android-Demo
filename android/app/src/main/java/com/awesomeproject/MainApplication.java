package com.awesomeproject;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.growingio.android.sdk.gtouch.rn.RNGrowingTouchPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import com.growingio.android.plugin.rn.GrowingIOPackage;
import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;


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
          new RNGrowingTouchPackage(),
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
            .trackAllFragments()
            .setTestMode(BuildConfig.DEBUG)
            .setDebugMode(BuildConfig.DEBUG)
            .setChannel("HangZhou")
    );
  }
}
