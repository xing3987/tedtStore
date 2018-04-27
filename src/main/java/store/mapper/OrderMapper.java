package store.mapper;

import store.bean.Order;
import store.bean.OrderItem;

public interface OrderMapper {
	public void insertOrder(Order order);			//添加订单	
	public void insertOrderItem(OrderItem orderItem);		//添加订单商品
	public void updatePaymentStatusByOrderId(Integer orderId);//根据订单id修改订单支付状态
}
