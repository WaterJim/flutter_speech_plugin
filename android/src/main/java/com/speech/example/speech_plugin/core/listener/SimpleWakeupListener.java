package com.speech.example.speech_plugin.core.listener;


import com.speech.example.speech_plugin.core.WakeUpResult;
import com.speech.example.speech_plugin.utils.PluginLogger;


public class SimpleWakeupListener implements IWakeupListener {

    private static final String TAG = "SimpleWakeupListener";

    @Override
    public void onSuccess(String word, WakeUpResult result) {
        PluginLogger.info(TAG, "唤醒成功，唤醒词：" + word);
    }

    @Override
    public void onStop() {
        PluginLogger.info(TAG, "唤醒词识别结束：");
    }

    @Override
    public void onError(int errorCode, String errorMessge, WakeUpResult result) {
        PluginLogger.info(TAG, "唤醒错误：" + errorCode + ";错误消息：" + errorMessge + "; 原始返回" + result.getOrigalJson());
    }

    @Override
    public void onASrAudio(byte[] data, int offset, int length) {
        PluginLogger.error(TAG, "audio data： " + data.length);
    }

}
