# MyDeviceInfo
A simple class to get Android device information for debugging purposes and send it out by an email intent.

# Usage
* Import the two files MyDeviceInfo.java and MyStorageInfo.java into your project.
* Get device information like this. Call inside an Activity to pass the context and package identifier:
<pre>
try
{
	MyDeviceInfo info = new MyDeviceInfo(YourActivity.this, "com.example.yourapplication");
	info.sendEmail(MyDeviceInfo.MODE_TXT_INLINE);
}
catch(Exception e)
{
	e.printStackTrace();
}
</pre>

* sendEmail() takes a flag:
	* MODE_TXT_INLINE inlines the device report.
	* MODE_TXT_ATTACHMENT attaches the report as text file. No special write permissions needed for getExternalCacheDir() call.

* use getReport() to get a string dump.	
	
# Notes
* Build against SDK 24
* Tested on API Level 22

# Known Issues
* Some function used in class MyStorageInfo are deprecated (Jan. 2017).
* Code has become obsolete. You can use [Google Crashlytics](https://firebase.google.com/docs/crashlytics/) to get much better device (and crash) information (March 2018).

# Sample Output (Nexus 4, running Android 5.1.1)
<pre>
Device information report:


Device Info v1.0.0b3(3)
net.mat8854.prototype 1.0.0b3 (3)
Locale: de_DE

** Device:
Board: MAKO
Brand: google
Device: mako
Model: Nexus 4
Product: occam
TAGS: release-keys

** OS:
Build release 5.1.1, Inc: '2237560'
Display build: LMY48T
Finger print: google/occam/mako:5.1.1/LMY48T/2237560:user/release-keys
Build ID: LMY48T
Time: 1441745481000
Type: user
User: android-build

** Density:
density: 2.0
densityDpi: 320
scaledDensity: 2.0
xdpi: 319.79
ydpi: 318.745

** Density reference:
DENSITY_DEFAULT: 160
DENSITY_LOW: 120
DENSITY_MEDIUM: 160
DENSITY_HIGH: 240

** Screen:
heightPixels: 1184
widthPixels: 768

** Storage:
internal storage = 927MB/ 13,231MB
external storage = 927MB/ 13,231MB

** Features:
FeatureInfo{3ab8f384 android.hardware.sensor.proximity fl=0x0}
FeatureInfo{370a176d android.hardware.sensor.accelerometer fl=0x0}
FeatureInfo{dbd5fa2 android.hardware.faketouch fl=0x0}
FeatureInfo{26114433 android.hardware.usb.accessory fl=0x0}
FeatureInfo{2a93c3f0 android.software.backup fl=0x0}
FeatureInfo{223dbd69 android.hardware.touchscreen fl=0x0}
FeatureInfo{c35d3ee android.hardware.touchscreen.multitouch fl=0x0}
FeatureInfo{3191f08f android.software.print fl=0x0}
FeatureInfo{30092f1c android.hardware.ethernet fl=0x0}
FeatureInfo{bebc725 android.software.voice_recognizers fl=0x0}
FeatureInfo{15af40fa android.hardware.sensor.gyroscope fl=0x0}
FeatureInfo{1cc706ab android.hardware.audio.low_latency fl=0x0}
FeatureInfo{38082108 android.hardware.bluetooth fl=0x0}
FeatureInfo{29b6b0a1 android.hardware.camera.autofocus fl=0x0}
FeatureInfo{2a2072c6 com.google.android.feature.GOOGLE_BUILD fl=0x0}
FeatureInfo{1ded6287 android.hardware.telephony.gsm fl=0x0}
FeatureInfo{d8245b4 android.software.sip.voip fl=0x0}
FeatureInfo{eecb5dd android.hardware.audio.output fl=0x0}
FeatureInfo{20f552 android.hardware.camera.flash fl=0x0}
FeatureInfo{2833a023 android.hardware.camera.front fl=0x0}
FeatureInfo{16d80920 android.hardware.screen.portrait fl=0x0}
FeatureInfo{3b83d2d9 android.hardware.nfc fl=0x0}
FeatureInfo{2e35149e android.software.home_screen fl=0x0}
FeatureInfo{29161b7f android.hardware.microphone fl=0x0}
FeatureInfo{3e04974c android.hardware.bluetooth_le fl=0x0}
FeatureInfo{1ed5c395 android.hardware.sensor.compass fl=0x0}
FeatureInfo{1cd9dcaa android.hardware.touchscreen.multitouch.jazzhand fl=0x0}
FeatureInfo{3f7af09b android.hardware.sensor.barometer fl=0x0}
FeatureInfo{2f89dc38 android.software.app_widgets fl=0x0}
FeatureInfo{a1c0411 android.software.input_methods fl=0x0}
FeatureInfo{d511976 android.hardware.sensor.light fl=0x0}
FeatureInfo{88dfb77 android.software.device_admin fl=0x0}
FeatureInfo{1c1c83e4 android.hardware.camera fl=0x0}
FeatureInfo{eabd04d android.hardware.screen.landscape fl=0x0}
FeatureInfo{12d5702 android.software.managed_users fl=0x0}
FeatureInfo{1e5cd813 android.software.webview fl=0x0}
FeatureInfo{290ffa50 android.hardware.camera.any fl=0x0}
FeatureInfo{3f22449 android.software.connectionservice fl=0x0}
FeatureInfo{e9de14e android.hardware.touchscreen.multitouch.distinct fl=0x0}
FeatureInfo{2432e26f android.hardware.location.network fl=0x0}
FeatureInfo{3b826b7c android.software.sip fl=0x0}
FeatureInfo{312fbc05 android.hardware.wifi.direct fl=0x0}
FeatureInfo{2d7ac45a android.software.live_wallpaper fl=0x0}
FeatureInfo{3cb5368b com.google.android.feature.GOOGLE_EXPERIENCE fl=0x0}
FeatureInfo{a48c368 com.google.android.feature.EXCHANGE_6_2 fl=0x0}
FeatureInfo{16f51381 android.hardware.location.gps fl=0x0}
FeatureInfo{910cc26 android.hardware.nfc.hce fl=0x0}
FeatureInfo{5beb067 android.hardware.wifi fl=0x0}
FeatureInfo{229aae14 android.hardware.location fl=0x0}
FeatureInfo{145e66bd android.hardware.telephony fl=0x0}
FeatureInfo{22ad84b2 glEsVers=3.0 fl=0x0}
</pre>

