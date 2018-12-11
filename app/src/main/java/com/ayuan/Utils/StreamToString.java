package com.ayuan.Utils;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamToString {
	private static final String TAG = "StreamToString";

	public static String toString(InputStream inputStream) {
		ByteArrayOutputStream byteArrayOutputStream = null;
		String jsonString = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			int len = -1;
			byte[] bytes = new byte[1024];
			while ((len = inputStream.read(bytes)) != -1) {
				byteArrayOutputStream.write(bytes, 0, len);
			}
			jsonString = byteArrayOutputStream.toString();
		} catch (IOException e) {
			e.printStackTrace();
			Log.i(TAG, "哈哈:StreamToString--------流转换成字符串出现问题");
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return jsonString;
		}
	}
}
