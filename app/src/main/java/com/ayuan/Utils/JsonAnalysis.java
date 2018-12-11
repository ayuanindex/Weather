package com.ayuan.Utils;

import android.util.Log;

import com.ayuan.db.domain.CityInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * json解析类
 */
public class JsonAnalysis {
	private static final String TAG = "JsonAnalysis";

	public static ArrayList<CityInfo> getCity(String json) {
		ArrayList<CityInfo> cityInfos = null;
		try {
			JSONArray jsonArray = new JSONArray(json);
			cityInfos = new ArrayList<CityInfo>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int id = jsonObject.optInt("_id");
				String city_code = jsonObject.optString("city_code");
				String city_name = jsonObject.optString("city_name");
				CityInfo cityInfo = new CityInfo(id, city_code, city_name);
				cityInfos.add(cityInfo);
			}
			return cityInfos;
		} catch (JSONException e) {
			e.printStackTrace();
			Log.i(TAG, "哈哈:json解析发生异常");
		} catch (Exception e) {
			e.printStackTrace();
			Log.i(TAG, "哈哈:发生未知异常");
		} finally {
			return cityInfos;
		}
	}
}
