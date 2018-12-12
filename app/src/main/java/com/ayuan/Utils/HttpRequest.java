package com.ayuan.Utils;

import android.util.Log;

import com.ayuan.db.domain.CityInfo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpRequest {
	private static final String TAG = "HttpRequest";
	private static String PATH = "http://t.weather.sojson.com/api/weather/city/";

	public static ArrayList<CityInfo> httpGetCity() {
		ArrayList<CityInfo> city = null;
		String jsonString = httpSetting("http://10.0.2.2:8080/_city.json");
		Log.i(TAG, "工具类:" + jsonString);
		city = JsonAnalysis.getCity(jsonString);
		if (city != null) {
			return city;
		}
		return city;
	}

	private static String httpSetting(String path) {
		String jsonString = "";
		try {
			Log.i(TAG, "地址:" + path);
			URL url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setReadTimeout(5000);
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			httpURLConnection.setRequestProperty("accept", "application/json");
			if (jsonString != null) {
				byte[] bytes = jsonString.getBytes();
				//设置文件长度
				httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
				OutputStream outputStream = httpURLConnection.getOutputStream();
				outputStream.write(bytes);
				outputStream.flush();
				outputStream.close();
			}
			int code = httpURLConnection.getResponseCode();
			if (code == 200) {
				InputStream inputStream = httpURLConnection.getInputStream();
				if (inputStream != null) {
					String json = StreamToString.toString(inputStream);
					Log.i(TAG, "哈哈:" + json);
					return json;
				} else {
					inputStream.close();
				}
			} else {
				return jsonString;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonString;
		} finally {
			return jsonString;
		}
	}
}
