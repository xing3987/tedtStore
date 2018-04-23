package store.bean;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable{
	private static final long serialVersionUID = -1503960660083507918L;
	private Integer id;
	private Integer uid;
	private String goodsId;
	private Integer count;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", count=" + count + ", createdUser="
				+ createdUser + ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser + ", modifiedTime="
				+ modifiedTime + "]";
	}
	public Cart() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Cart(Integer id, Integer uid, String goodsId, Integer count, String createdUser, Date createdTime,
			String modifiedUser, Date modifiedTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.goodsId = goodsId;
		this.count = count;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}
	
}
