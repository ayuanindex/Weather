package com.ayuan.db.domain;

public class CityInfo {
	private Integer _id;
	private String city_code;
	private String city_name;

	public CityInfo() {

	}

	public CityInfo(Integer _id, String city_code, String city_name) {
		this._id = _id;
		this.city_code = city_code;
		this.city_name = city_name;
	}

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	@Override
	public String toString() {
		return "CityInfo{" +
				"_id=" + _id +
				", city_code='" + city_code + '\'' +
				", city_name='" + city_name + '\'' +
				'}';
	}
}
