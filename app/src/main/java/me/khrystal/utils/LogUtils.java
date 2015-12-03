package me.khrystal.utils;

/**
 * Created by yao on 15-9-18:上午7:46.
 */
public class LogUtils {

    private static final String TAG = "Test";

    public static final boolean DEBUGGABLE = true;

    private static final int MAX_ENABLED_LOG_LEVEL = DEBUGGABLE ? android.util.Log.VERBOSE
            : android.util.Log.INFO;

    public static boolean isLoggable(int level) {
        return MAX_ENABLED_LOG_LEVEL <= level;
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (isLoggable(android.util.Log.VERBOSE)) {
            android.util.Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (isLoggable(android.util.Log.DEBUG)) {
            android.util.Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isLoggable(android.util.Log.INFO)) {
            android.util.Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        wtf(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (isLoggable(android.util.Log.WARN)) {
            android.util.Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (isLoggable(android.util.Log.ERROR)) {
            android.util.Log.e(tag, msg);
        }
    }

    public static void wtf(String msg) {
        wtf(TAG, msg);
    }

    public static void wtf(String tag, String msg) {
        if (isLoggable(android.util.Log.ASSERT)) {
            android.util.Log.wtf(tag, msg);
        }
    }
}