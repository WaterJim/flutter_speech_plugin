import 'dart:async';

import 'package:flutter/services.dart';

class SpeechPlugin {
  static const MethodChannel _channel =
      const MethodChannel('speech_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
