package me.khrystal.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import me.khrystal.MyApplication;
import me.khrystal.R;

/**
 * Created by yao on 15/10/20:下午11:46.
 */
public class FileUtils {

    public static File getCacheDir() {
        Context context = MyApplication.getInstance();
        File cacheDir = context.getExternalCacheDir();
        if (cacheDir == null) {
            File sdDir = Environment.getExternalStorageDirectory();
            cacheDir = new File(sdDir, "/android/data/" + context.getPackageName()
                    + "/cache");
        }
        return cacheDir;

    }

    public static boolean hasSDCard() {
        String t = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(t);
    }

    private static final String SPLASH_FILE = "splash";

    public static File getSplashFile() {
        return new File(MyApplication.getInstance().getCacheDir(), SPLASH_FILE);
    }

    public static BitmapDrawable getSplashImage() {
        return new BitmapDrawable(MyApplication.getInstance().getResources(),
                getSplashFile().getAbsolutePath());
    }

    private static final String AVATAR_FILE = "avatar.jpg";

    public static File getAvatarFile() {
        return new File(getCacheDir(), AVATAR_FILE);
    }

    public static BitmapDrawable getAvatarDrawable() {
        if (getAvatarFile().exists()) {
            return new BitmapDrawable(MyApplication.getInstance().getResources(),
                    getAvatarFile().getAbsolutePath());
        } else {
            return
                    (BitmapDrawable) MyApplication.getInstance().getResources()
                            .getDrawable(R.drawable.avatar_bg_normal);
        }
    }

    public static void writeAvatarFile(byte[] data) {
        FileOutputStream fos;
        try {
            File dir = MyApplication.getInstance().getCacheDir();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File f = getAvatarFile();
            fos = new FileOutputStream(f);
            fos.write(data, 0, data.length);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] inputStreamToByteArray(InputStream is) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];

        try {
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
        } catch (Exception e) {
            Log.e("FileUtils", Log.getStackTraceString(e));
        }
        return buffer.toByteArray();
    }

    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            byte[] b = new byte[1024 * 10];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } finally {
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
        }
    }


}
