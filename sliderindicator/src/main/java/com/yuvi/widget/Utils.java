package com.yuvi.widget;

import android.content.Context;
import android.util.Log;

/**
 * Created by yubaraj on 12/21/17.
 */

public class Utils {

    public static void log(Class<?> mClass, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(mClass.getSimpleName(), message);
        }
    }

    public static int dpFromPx(Context context, float px) {
        return (int) (px / context.getResources().getDisplayMetrics().density);
    }

    public static int pxFromDp(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public static int pxFromSp(Context context, int sp) {
        return (int) (sp * context.getResources().getDisplayMetrics().scaledDensity);
    }

}
