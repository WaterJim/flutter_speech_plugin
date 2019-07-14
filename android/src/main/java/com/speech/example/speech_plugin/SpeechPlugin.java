package com.speech.example.speech_plugin;

import android.app.Activity;
import android.content.Context;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * SpeechPlugin
 */
public class SpeechPlugin implements MethodCallHandler {

    private BdAsrManager mAsrManager;

    /**
     * Plugin registration.
     */
    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "speech_plugin");
        channel.setMethodCallHandler(new SpeechPlugin(registrar.context(), registrar.activity()));
    }

    public SpeechPlugin(Context context, Activity activity) {
        mAsrManager = BdAsrManager.getInstance(context, activity);
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("getPlatformVersion")) {
            mAsrManager.startAsr();
            result.success("Android " + android.os.Build.VERSION.RELEASE);
        } else {
            result.notImplemented();
        }
    }
}
