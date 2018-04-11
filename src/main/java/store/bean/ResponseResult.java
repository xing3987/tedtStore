package store.bean;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable{
	private static final long serialVersionUID = 4948819216603094441L;
	
	private Integer state;//状态码0表示错误，1表示正确
	private String message;
	private T data;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
