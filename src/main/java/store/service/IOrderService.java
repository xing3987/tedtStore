package store.service;

import java.util.List;

import store.bean.CartVo;

//订单管理业务层接口
public interface IOrderService {
	public List<CartVo> getOrderByIds(Integer uid,Integer[] ids);
}
