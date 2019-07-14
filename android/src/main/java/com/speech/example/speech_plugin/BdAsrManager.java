package com.speech.example.speech_plugin;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.baidu.speech.asr.SpeechConstant;
import com.speech.example.speech_plugin.core.WakeUpHandler;
import com.speech.example.speech_plugin.core.listener.SimpleWakeupListener;
import com.speech.example.speech_plugin.utils.PluginLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BdAsrManager{

    private static BdAsrManager mInstance;

    private Context mContext;
    private Activity mActivity;

    private WakeUpHandler mWakeUpHandler;

    public static BdAsrManager getInstance(Context context, Activity activity) {
        if (mInstance == null) {
            mInstance = new BdAsrManager(context, activity);
        }
        return mInstance;
    }

    private BdAsrManager (Context context, Activity activity) {
        mContext = context;
        mActivity = activity;

        mWakeUpHandler = new WakeUpHandler(mContext, new SimpleWakeupListener());
    }

    public void startAsr() {
        initPermission();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put(SpeechConstant.WP_WORDS, "测试");
        mWakeUpHandler.start(params);
    }

    private void initPermission() {
        String permissions[] = {Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm :permissions){
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(mContext, perm)) {
                toApplyList.add(perm);
                //进入到这里代表没有权限.
                PluginLogger.info("没有相关权限");
            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()){
            ActivityCompat.requestPermissions(mActivity, toApplyList.toArray(tmpList), 123);
        }
    }
}
