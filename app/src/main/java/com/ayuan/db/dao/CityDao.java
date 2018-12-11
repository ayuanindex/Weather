package com.ayuan.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ayuan.db.CityOpenHelper;

/**
 * 使用单例模式操作数据库
 */
public class CityDao {

	private final CityOpenHelper cityOpenHelper;

	private CityDao(Context context) {
		cityOpenHelper = new CityOpenHelper(context, "city", null, 1);
	}

	private static CityDao cityDao = null;

	public static CityDao getInstence(Context context) {
		if (cityDao != null) {
			cityDao = new CityDao(context);
		}
		return null;
	}

	/**
	 * 根据城市的名字查询对应的city_code
	 *
	 * @param cityName 传入对的城市的名字
	 * @return 返回城市所对应的code
	 */
	public String findByCity_Name(String cityName) {
		SQLiteDatabase database = cityOpenHelper.getWritableDatabase();
		Cursor city = database.query("city", new String[]{"city_code"}, "city_name=?", new String[]{cityName}, null, null, null);
		String city_code = null;
		if (city.getCount() >= 1) {
			while (city.moveToNext()) {
				city_code = city.getString(0);
				return city_code;
			}
		}
		return city_code;
	}

	/**
	 * 往数据库中插入城市的数据
	 *
	 * @param _id       城市对应的列id
	 * @param city_code 城市对应的code
	 * @param city_name 城市对应的name
	 */
	public void insert(int _id, String city_code, String city_name) {
		SQLiteDatabase database = cityOpenHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("_id", _id);
		contentValues.put("city_code", city_code);
		contentValues.put("city_name", city_name);
		database.insert("city", null, contentValues);
	}
}
