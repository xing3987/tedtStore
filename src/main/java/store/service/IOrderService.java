package store.service;

import java.util.List;

import store.bean.CartVo;
import store.bean.Order;

//订单管理业务层接口
public interface IOrderService {
	public List<CartVo> getOrderByIds(Integer uid,Integer[] ids);
	public void addOrder(Order order,List<CartVo> cartVos);//添加订单信息，和订单详情信息
	public void updateItem(Integer orderId);//通过orderId修改订单支付状态
}
