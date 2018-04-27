package store.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1248123868641072524L;
	
	private Integer id;
	private Integer uid;
	private String goodsId;
	private String image;
	private String title;
	private Integer price;
	private Integer count;
	private Integer paymentStatus;
	private Integer orderStatus;
	private Integer orderId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
		return "OrderItem [id=" + id + ", uid=" + uid + ", goodsId=" + goodsId + ", image=" + image + ", title=" + title
				+ ", price=" + price + ", count=" + count + ", paymentStatus=" + paymentStatus + ", orderStatus="
				+ orderStatus + ", orderId=" + orderId + ", createdUser=" + createdUser + ", createdTime=" + createdTime
				+ ", modifiedUser=" + modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	public OrderItem() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public OrderItem(Integer id, Integer uid, String goodsId, String image, String title, Integer price, Integer count,
			Integer paymentStatus, Integer orderStatus, Integer orderId, String createdUser, Date createdTime,
			String modifiedUser, Date modifiedTime) {
		super();
		this.id = id;
		this.uid = uid;
		this.goodsId = goodsId;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
		this.paymentStatus = paymentStatus;
		this.orderStatus = orderStatus;
		this.orderId = orderId;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
		this.modifiedUser = modifiedUser;
		this.modifiedTime = modifiedTime;
	}
	
}
