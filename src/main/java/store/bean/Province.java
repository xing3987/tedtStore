package store.bean;

import java.io.Serializable;

public class Province implements Serializable{
	private static final long serialVersionUID = -1210621674639064043L;
	
	private Integer id;
	private String provinceCode;
	private String provinceName;
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
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "Provinces [id=" + id + ", provinceCode=" + provinceCode + ", provinceName=" + provinceName + "]";
	}
	public Province(Integer id, String provinceCode, String provinceName) {
		super();
		this.id = id;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}
	public Province() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
}
