package com.ayuan.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
	public static String CONFIG = "config";

	private static SharedPreferences sharedPreferences;

	public static void putBoolean(Context context, String key, boolean value) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
		}
		sharedPreferences.edit().putBoolean(key, value).commit();
	}

	public static boolean getBoolean(Context context, String key, boolean defValue) {
		if (sharedPreferences == null) {
			sharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		}
		return sharedPreferences.getBoolean(key, defValue);
	}
}
