package com.ayuan.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ayuan.Utils.JsonAnalysis;
import com.ayuan.Utils.SpUtils;
import com.ayuan.Utils.StreamToString;
import com.ayuan.db.dao.CityDao;
import com.ayuan.db.domain.CityInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	private CityDao cityInstence;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initUI();
		initData();
	}

	/**
	 * 加载界面控件
	 */
	private void initUI() {

	}

	/**
	 * 从数据库加载城市信息
	 */
	private void initData() {
		//获取操作数据库的对象
		/*cityInstence = CityDao.getInstence(this);
		boolean config = SpUtils.getBoolean(this, SpUtils.CONFIG, false);*/
		//加载json文件进入数据库
		try {
			InputStream open = getAssets().open("_city.json");
			String jsonString = StreamToString.toString(open);
			ArrayList<CityInfo> cityInfos = JsonAnalysis.getCity(jsonString);
			Log.i(TAG, "哈哈:执行结束");
			/*initDataBase(cityInfos);*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将获取的json存储到数据库中
	 *
	 * @param cityInfos 等待解析的json字符串
	 */
	private void initDataBase(ArrayList<CityInfo> cityInfos) {
		//将解析好的json数据的集合存放到数据库中
		Iterator<CityInfo> infoIterator = cityInfos.iterator();
		while (infoIterator.hasNext()) {
			CityInfo next = infoIterator.next();
			cityInstence.insert(next.get_id(), next.getCity_code(), next.getCity_name());
		}
		//数据的存放操作执行成功之后向sp文件中写入标识，之后将不再解析json数据
		/*SpUtils.putBoolean(this, SpUtils.CONFIG, true);*/
	}
}
