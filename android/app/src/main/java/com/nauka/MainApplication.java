package com.nauka;

import android.app.Application;
import android.content.Context;

import androidx.annotation.Nullable;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.List;

public class MainApplication extends Application implements ReactApplication {

    private static MainApplication instance;

    public static MainApplication getInstance() {
        return instance;
    }

    private final ReactNativeHost mReactNativeHost =
            new DefaultReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    @SuppressWarnings("UnnecessaryLocalVariable")
                    List<ReactPackage> packages = new PackageList(this).getPackages();
                    // Packages that cannot be autolinked yet can be added manually here, for example:
                    // packages.add(new MyReactNativePackage());
                    return packages;
                }

                @Nullable
                @Override
                protected String getBundleAssetName() {
                    return "index.android.bundle";
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }

                @Override
                protected boolean isNewArchEnabled() {
                    return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
                }

                @Nullable
                @Override
                protected JSIModulePackage getJSIModulePackage() {

                    return super.getJSIModulePackage();
                }

                @Override
                protected Boolean isHermesEnabled() {
                    return BuildConfig.IS_HERMES_ENABLED;
                }

                @Override
                protected ReactInstanceManager createReactInstanceManager() {
                    ReactInstanceManagerBuilder builder = ReactInstanceManager.builder();
                    builder.setApplication(MainApplication.instance);
                    builder.addPackage(new MainReactPackage());
                    // JS 异常回调处理实现，在这个实现中我们可以打印 JS 异常日志，上报错误
                    builder.setRedBoxHandler(new RedBoxHandler() {
                        @Override
                        public void handleRedbox(@Nullable String errString, StackFrame[] stackFrames, ErrorType errorType) {

                        }

                        @Override
                        public boolean isReportEnabled() {
                            return false;
                        }

                        @Override
                        public void reportRedbox(Context context, String s, StackFrame[] stackFrames, String s1, ReportCompletedListener reportCompletedListener) {

                        }
                    });
                    return builder.build();
                }
            };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        instance = this;
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            // If you opted-in for the New Architecture, we load the native entry point for this app.
            DefaultNewArchitectureEntryPoint.load();
        }
        ReactNativeFlipper.initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
    }

}
