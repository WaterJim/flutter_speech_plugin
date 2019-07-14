package com.speech.example.speech_plugin.core.listener;

import com.speech.example.speech_plugin.core.WakeUpResult;


public interface IWakeupListener {
    void onSuccess(String word, WakeUpResult result);

    void onStop();

    void onError(int errorCode, String errorMessge, WakeUpResult result);

    void onASrAudio(byte[] data, int offset, int length);
}
