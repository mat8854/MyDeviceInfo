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

# Notes
* Build against SDK 24
* Tested on API Level 22

# Known Issues
* Some function used in class MyStorageInfo are deprecated (Jan. 2017).

# Sampe Output (Nexus 4, running Android 5.1.1)
<pre>
Device information report:

Device Info v1.0.0b2(1)
net.mat8854.prototype 1.0.0b2 (1)
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
internal storage = 761MB/ 13,231MB
external storage = 761MB/ 13,231MB
</pre>

