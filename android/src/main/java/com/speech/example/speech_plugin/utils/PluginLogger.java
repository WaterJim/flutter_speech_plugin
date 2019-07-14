package com.speech.example.speech_plugin.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by waterchen on 2019/7/11.
 */
public class PluginLogger {

    private static final String TAG = "MyLogger";

    private static final String INFO = "INFO";

    private static final String ERROR = "ERROR";

    private static final boolean ENABLE = true;

    private static Handler handler;

    public static void info(String message) {
        info(TAG, message);
    }

    public static void info(String tag, String message) {
        log(INFO, tag, message);
    }

    public static void error(String message) {
        error(TAG, message);
    }

    public static void error(String tag, String message) {
        log(ERROR, tag, message);
    }

    public static void setHandler(Handler handler) {
        PluginLogger.handler = handler;
    }

    private static void log(String level, String tag, String message) {
        if (!ENABLE) {
            return;
        }
        if (level.equals(INFO)) {
            Log.i(tag, message);

        } else if (level.equals(ERROR)) {
            Log.e(tag, message);
        }
        if (handler != null) {
            Message msg = Message.obtain();
            msg.obj = "[" + level + "]" + message + "\n";
            handler.sendMessage(msg);
        }
    }
}
