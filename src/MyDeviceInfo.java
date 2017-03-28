package net.mat8854.prototype;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class MyDeviceInfo {

    private Activity mActivtiy;
    private String mReport = "";
    private String mAppName = "Device information";

    public static final int MODE_TXT_INLINE = 1;
    public static final int MODE_TXT_ATTACHMENT = 2;

    public static final String sFile = "device_information.txt";

    private static final String[] SEND_TO_EMAIL = new String[]{
            "mail@domain.com"
    };

    public MyDeviceInfo(Activity activity, String sPackage) {
        mActivtiy = activity;

        mReport = "Device information report:\n";
        try {
            PackageInfo info = mActivtiy.getApplication().getPackageManager().getPackageInfo(mActivtiy.getApplication().getPackageName(), 0);
            String mAppName = "\nDevice Info v" + info.versionName + "(" + info.versionCode + ")";
            addToReport(mAppName);

            addToReport(getPkgVersion(sPackage));

            addToReport("Locale: " + mActivtiy.getResources().getConfiguration().locale.toString());

            addToReport("\n** Device:");
            addToReport("Board: " + android.os.Build.BOARD);
            addToReport("Brand: " + android.os.Build.BRAND);
            addToReport("Device: " + android.os.Build.DEVICE);
            addToReport("Model: " + android.os.Build.MODEL);
            addToReport("Product: " + android.os.Build.PRODUCT);
            addToReport("TAGS: " + android.os.Build.TAGS);

            addToReport("\n** OS:");
            addToReport("Build release " + android.os.Build.VERSION.RELEASE + ", Inc: '" + android.os.Build.VERSION.INCREMENTAL + "'");
            addToReport("Display build: " + android.os.Build.DISPLAY);
            addToReport("Finger print: " + android.os.Build.FINGERPRINT);
            addToReport("Build ID: " + android.os.Build.ID);
            addToReport("Time: " + android.os.Build.TIME);
            addToReport("Type: " + android.os.Build.TYPE);
            addToReport("User: " + android.os.Build.USER);

            addToReport("\n** Density:");
            DisplayMetrics metrics = new DisplayMetrics();
            mActivtiy.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            addToReport("density: " + metrics.density);
            addToReport("densityDpi: " + metrics.densityDpi);
            addToReport("scaledDensity: " + metrics.scaledDensity);
            addToReport("xdpi: " + metrics.xdpi);
            addToReport("ydpi: " + metrics.ydpi);

            addToReport("\n** Density reference:");
            addToReport("DENSITY_DEFAULT: " + DisplayMetrics.DENSITY_DEFAULT);
            addToReport("DENSITY_LOW: " + DisplayMetrics.DENSITY_LOW);
            addToReport("DENSITY_MEDIUM: " + DisplayMetrics.DENSITY_MEDIUM);
            addToReport("DENSITY_HIGH: " + DisplayMetrics.DENSITY_HIGH);

            addToReport("\n** Screen:");
            addToReport("heightPixels: " + metrics.heightPixels);
            addToReport("widthPixels: " + metrics.widthPixels);

            addToReport("\n** Storage:");

            addToReport("internal storage = " + MyStorageInfo.getAvailableInternalMemorySize().toString() + "/ " + MyStorageInfo.getTotalInternalMemorySize().toString());
            if (MyStorageInfo.externalMemoryAvailable()) {
                addToReport("external storage = " + MyStorageInfo.getAvailableExternalMemorySize().toString() + "/ " + MyStorageInfo.getTotalExternalMemorySize().toString());
            } else {
                addToReport("no external storage");
            }

            addToReport("\n** Features:");
            addToReport(getFeatures());

            addToReport("\n");

        } catch (Exception e) {
            e.printStackTrace();
            addToReport("Exception: " + e.toString());
        }
    }

    private String getPkgVersion(String packageName) {
        try {
            PackageInfo info = mActivtiy.getApplication().getPackageManager().getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return packageName + " " + info.versionName + " (" + info.versionCode + ")";
        } catch (PackageManager.NameNotFoundException e) {
            return "Failed to get '" + packageName + "' info: " + e.getMessage();
        }
    }

    private void addToReport(String text) {
        mReport = mReport + "\n" + text;
    }

    public String getReport()
    {
        return  mReport;
    }

    public void sendEmail(int mode) {

        final Intent i = new Intent(android.content.Intent.ACTION_SEND);

        if (mode == MODE_TXT_INLINE) {
            i.putExtra(android.content.Intent.EXTRA_TEXT, mReport);
        } else if (mode == MODE_TXT_ATTACHMENT) {
            // create file in cache
            writeToFile(sFile, mReport);

            // attach file
            File file = new File(mActivtiy.getExternalCacheDir().toString() + "/" + sFile);
            i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        } else {
            // additional modes
        }

        i.setType("plain/text");
        i.putExtra(android.content.Intent.EXTRA_EMAIL, SEND_TO_EMAIL);
        i.putExtra(android.content.Intent.EXTRA_SUBJECT, mAppName);

        mActivtiy.startActivity(Intent.createChooser(i, "Send mail ..."));
    }

    public String getFeatures() {
        PackageManager packageManager = mActivtiy.getApplicationContext().getPackageManager();
        FeatureInfo[] feature = packageManager.getSystemAvailableFeatures();
        String sFeatures = "";
        for(FeatureInfo s: feature)
        {
            sFeatures += s.toString() + "\n";
        }

        return sFeatures;
    }

    public void writeToFile(String fileName, String content) {

        FileOutputStream outputStream;
        File file;

        try
        {
            file = new File(mActivtiy.getExternalCacheDir(), fileName);
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
