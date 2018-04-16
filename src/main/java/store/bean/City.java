package store.bean;

import java.io.Serializable;

public class City implements Serializable{
	private static final long serialVersionUID = -2906057722906514359L;
	private Integer id;
	private String provinceCode;
	private String cityCode;
	private String cityName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", provinceCode=" + provinceCode + ", cityCode=" + cityCode + ", cityName=" + cityName
				+ "]";
	}
	public City() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public City(Integer id, String provinceCode, String cityCode, String cityName) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}
	
	
}
