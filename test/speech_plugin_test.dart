import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:speech_plugin/speech_plugin.dart';

void main() {
  const MethodChannel channel = MethodChannel('speech_plugin');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await SpeechPlugin.platformVersion, '42');
  });
}
